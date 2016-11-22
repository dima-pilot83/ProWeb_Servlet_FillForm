package ru.mail.dimapilot;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteRead {

	protected String ch;

	protected void write(String name, String surname, int age, String study, String pets) {

		try {
			File f = new File("D://11.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");

			raf.seek(f.length());

			// Append data
			raf.writeUTF("Name:" + name + ",  Surname:" + surname + ",  Age:" + Integer.toString(age) + ",  Study at:"
					+ study + ",  Pets :" + pets + " <br> ");

			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
