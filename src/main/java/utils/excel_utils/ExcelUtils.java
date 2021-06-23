package utils.excel_utils;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    public String outExcelDemo(HttpServletResponse response) throws IOException, IllegalAccessException {
        //文件名
        String fileName = "活动报名情况一览表";
        //sheet名
        String sheetName = "报名情况sheet";

        //表头集合，作为表头参数
        List<String> titleList = new ArrayList<String>();
        titleList.add("用户账户");
        titleList.add("用户名");
        titleList.add("报名时间");
        titleList.add("是否完成");

        //数据对象，这里模拟手动添加，真实的环境往往是从数据库中得到
        SignOutExcelJSON excelJSON = new SignOutExcelJSON();
        excelJSON.setAccount("18210825916");
        excelJSON.setUsername("张三");
        excelJSON.setSigndate("2019-08-05");
        excelJSON.setFinish("是");
        SignOutExcelJSON excelJSON2 = new SignOutExcelJSON();
        excelJSON2.setAccount("15939305781");
        excelJSON2.setUsername("李四");
        excelJSON2.setSigndate("2019-08-01");
        excelJSON2.setFinish("否");
        //将两个对象加入到集合中，作为数据参数
        List<SignOutExcelJSON> excelJSONList = new ArrayList<SignOutExcelJSON>();
        excelJSONList.add(excelJSON);
        excelJSONList.add(excelJSON2);

        //调取封装的方法，传入相应的参数
        HSSFWorkbook workbook = createExcel(sheetName, titleList, excelJSONList);

        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        //中文名称要进行编码处理
        response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("GB2312"), "ISO8859-1") + ".xls");
        response.setContentType("application/x-xls");
        workbook.write(output);
        output.close();
        return null;
    }

    public static HSSFWorkbook createExcel(String sheetName,
                                           List<String> titleList,List dataList) throws IllegalAccessException {

        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet对象
        HSSFSheet sheet=wb.createSheet(sheetName);
        //在sheet里创建第一行，这里即是表头
        HSSFRow rowTitle=sheet.createRow(0);

        //写入表头的每一个列
        for (int i = 0; i < titleList.size(); i++) {
            //创建单元格
            rowTitle.createCell(i).setCellValue(titleList.get(i));
        }

        //写入每一行的记录
        for (int i = 0; i < dataList.size(); i++) {
            //创建新的一行，递增
            HSSFRow rowData = sheet.createRow(i+1);

            //通过反射，获取POJO对象
            Class cl = dataList.get(i).getClass();
            //获取类的所有字段
            Field[] fields = cl.getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                //设置字段可见，否则会报错，禁止访问
                fields[j].setAccessible(true);
                //创建单元格
                rowData.createCell(j).setCellValue((String) fields[j].get(dataList.get(i)));
            }
        }
        return wb;
    }
}
