package com.example.lb.crash.crashdemo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.util.Log;

/**
 * @ClassName: FileUtils
 * @Description:文件操作类
 * @author: libiao
 * @date: 2016-4-28 上午11:49:23
 */
public class FileUtils {
	/**
	 * sd卡的根目录
	 */
	private static String mSdRootPath = Environment.getExternalStorageDirectory().getPath();
	/**
	 * 手机的缓存根目录
	 */
	private static String mDataRootPath = null;
	/**
	 * 保存错误日志的路径
	 */
	public final static String FOLDER_NAME = "/AppCrash/logs/";

	public FileUtils(Context context) {
		mDataRootPath = context.getCacheDir().getPath();
	}


	public static String getStorageDirectory() {
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? mSdRootPath + FOLDER_NAME : mDataRootPath + FOLDER_NAME;
	}

	public static String getErrorLog() {
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) ? mSdRootPath + "/WalletLog.txt" : mDataRootPath
				+ "WalletLog.txt";
	}


	/**
	 * 将错误日志读取出来转化为String
	 * @return
     */
	public static String getErrorLogString() {
		String content = ""; // 文件内容字符串
		File file = new File(FileUtils.getErrorLog());
		if (file.exists()) {
			try {
				InputStream instream = new FileInputStream(file);
				if (instream != null) {
					InputStreamReader inputreader = new InputStreamReader(instream);
					BufferedReader buffreader = new BufferedReader(inputreader);
					String line;
					// 分行读取
					while ((line = buffreader.readLine()) != null) {
						content += line+"\n";
					}
					instream.close();
				}
			} catch (FileNotFoundException e) {
				Log.d("TestFile", "The File doesn't not exist.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}

	public static void deleteErrorLog() {
		File file = new File(FileUtils.getErrorLog());
		if (file.exists()) {
			file.delete();
		}
	}
}
