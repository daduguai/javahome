package algorithms.graph;

import java.util.LinkedList;

//图的深度优先算法
public class Graph {
    private int v;//顶点个数
    private LinkedList<Integer> adj[];//邻接表

    public Graph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
}
