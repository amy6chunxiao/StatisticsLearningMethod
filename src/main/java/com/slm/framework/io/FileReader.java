package com.slm.framework.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Title: FileReader.java
 * 
 * @description:从文件中读文件到内存util类
 * @author liucx
 * @created 2015年11月24日 下午4:07:19
 */
public class FileReader {
	/**
	 * 
	 * @description TODO
	 * @author liucx
	 * @created 2015年11月24日 下午4:07:39
	 * @param 文件存放绝对路径
	 * @return 字符串数组，源文件每一行数据对应数组每个元素
	 */
	public String[] readFile(String src) {
		List<String> content = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(src));
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				content.add(line);
			}
			br.close();
			isr.close();
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toArray(new String[content.size()]);
	}
}
