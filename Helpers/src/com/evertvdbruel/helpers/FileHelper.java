package com.evertvdbruel.helpers;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.content.Context;
import android.os.Environment;

public class FileHelper {

	public static boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		return false;
	}

	public static boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)
				|| Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			return true;
		}
		return false;
	}

	public static String getAbsolutePath(Context context, String fileName) {
		File file = new File(context.getExternalFilesDir(null), fileName);
		return file.getAbsolutePath();
	}

	public static Boolean writeByteArrayToFile(byte[] data, String fileName,
			Context context) throws IOException {
		File file = new File(context.getExternalFilesDir(null), fileName);
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				return false;
			}
		}

		file.createNewFile();
		OutputStream outputStream = new FileOutputStream(file);
		outputStream.write(data);
		outputStream.close();

		return true;
	}

	public static void unzipFile(Context context, BufferedInputStream is)
			throws IOException {
		ZipInputStream zis = new ZipInputStream(is);
		ZipEntry ze;

		while ((ze = zis.getNextEntry()) != null) {
			if (!ze.isDirectory()) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int count;
				while ((count = zis.read(buffer)) != -1) {
					baos.write(buffer, 0, count);
				}
				String filename = ze.getName();
				byte[] bytes = baos.toByteArray();
				FileHelper.writeByteArrayToFile(bytes, filename, context);
			}
		}
	}

	public static void unzipFile(Context context, String fileName) {
		try {
			File file = new File(context.getExternalFilesDir(null), fileName);
			FileHelper.unzipFile(context, new BufferedInputStream(
					new FileInputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] getByteArrayFromFile(File file)
			throws FileNotFoundException, IOException {
		return inputStreamToByteArray(new FileInputStream(file));
	}

	public static byte[] inputStreamToByteArray(InputStream is)
			throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while (is.available() > 0) {
			bos.write(is.read());
		}
		return bos.toByteArray();
	}

	public static Boolean fileExists(Context context, String fileName) {
		File file = new File(context.getExternalFilesDir(null), fileName);
		return file.exists();
	}
}
