package ru.mail.dimapilot;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Myform")
public class ServletFillForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletFillForm() {
		super();

	}

	private WriteRead wr = new WriteRead();
	protected int a1;
	protected String answer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String n = request.getParameter("name");
		String s = request.getParameter("surname");
		String a = request.getParameter("age");

		String std = request.getParameter("study");

		String p = request.getParameter("pets");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			a1 = Integer.parseInt(a);
			wr.write(n, s, a1, std, p);
		} catch (Exception ex) {
			out.println("Error, Input digits in AGE form! ");
		}

		try {
			File f = new File("D://11.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");

			while ((answer = raf.readUTF()) != null) {
				String res = new String(answer.getBytes("ISO-8859-1"), "windows-1251");
				out.println(res);
			}

			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
