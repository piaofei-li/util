package com.lpf.util.file;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author lipiaofei
 * @date 2019/07/22 11:16
 *
 * 依赖：
 *      servlet
 */
public class Download {

    /**
     * 下载文件（浏览器）
     *
     * 思路/步骤：
     *      使用response对象的输出流来达到下载文件的效果
     *      设置响应头与响应的内容类型与下载的文件名，将文件内容以流的方式放入response对象的输出流中
     *
     * @param response 响应对象
     * @throws IOException 异常
     */
    public void downloadFile(HttpServletResponse response) throws IOException {
        /* 将文件名转换为URL编码，防止文件名乱码 */
        String fileName = URLEncoder.encode("test.txt", StandardCharsets.UTF_8.name());
        /*  设置文件ContentType类型，这样设置，会自动判断下载文件类型   */
        response.setContentType("application/multipart/form-data");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        /* 设置文件头：最后一个参数是设置下载文件名(假如我们叫test.txt)   */
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        ServletOutputStream os = response.getOutputStream();
        os.write("test download".getBytes());
        os.flush();
        os.close();
    }
}
