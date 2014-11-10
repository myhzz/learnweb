package tools;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.TProblem;
import object.Video;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import dao.VideoDao;

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 20140126L;
	private ServletContext sc;
	private String savePath;
	private String mes[] = new String[20];

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void init(ServletConfig config) {
		// 鍦╳eb.xml涓缃殑涓�釜鍒濆鍖栧弬鏁�
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			int i = 0;
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			long time = System.currentTimeMillis();
			Date data = new Date(time);

			System.out.println("时间" + data);
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					System.out.println("表单参数名" + item.getFieldName() + "上传人姓名"
							+ item.getString("UTF-8"));
					mes[i++] = item.getString("UTF-8") + "";
				} else {

					if (item.getName() != null && !item.getName().equals("")) {
						TProblem tp=new TProblem(mes[2], mes[3], mes[4], mes[5], mes[6],mes[7]);
						Gson gson=new Gson();
						String Pproblem=gson.toJson(tp);
						String[] Ladr = item.getName().split("\\.");

						String Ladrr = Ladr[Ladr.length - 1];

						System.out.println("上传文件大小" + item.getSize());

						System.out.println("上传问价类型" + item.getContentType());
						// item.getName()返回上传文件在客户端的完整路径名称
						System.out.println("文件名称" + item.getName());

						File tempFile = new File(item.getName());
						// String lujing = sc.getRealPath("/") + savePath;
						String LJ = sc.getRealPath("/");

						System.out.println(sc.getRealPath("/")
								+ "+++++++++++++++" + savePath);
						// 获得ip
						InetAddress addr = InetAddress.getLocalHost();
						String ip = addr.getHostAddress().toString();// 获得本机IP
						System.out.println(ip);
						// 上传文件的保存路径
						File filess = new File(LJ);// 修改过后的
						String lujing = filess.getParent() + "/ROOT";

						File file = new File(lujing, time + "." + Ladrr);
						File files = new File(lujing);
						if (Ladrr.equals("png") || Ladrr.equals("jpg")) {
							VideoDao dao = new VideoDao();
							dao.InsertPIp(time + "", ip + ":8080/" + time + "."
									+ Ladrr);
						} else {
							Video video = new Video(mes[0], ip + ":8080/"
									+ time + "." + Ladrr, tempFile.getName(),
									mes[1], time + "",Pproblem,mes[8]);
							VideoDao dao = new VideoDao();
							dao.insertVideo(video);
						}
						if (!files.exists() && !files.isDirectory()) {
							System.out.println("//保存路径");
							files.mkdir();
						} else {
							System.out.println("//该路径已存在");
						}
						System.out.println(lujing);
						item.write(file);
						request.setAttribute("upload.message", "上传成功");
					} else {
						request.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("upload.message", "上传文件失败！");
		}
		request.getRequestDispatcher("/uploadResult.jsp").forward(request,
				response);
	}
}