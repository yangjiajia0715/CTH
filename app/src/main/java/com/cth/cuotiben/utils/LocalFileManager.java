package com.cth.cuotiben.utils;

import android.os.Environment;
import android.text.TextUtils;

import java.io.File;


/**
 * 对于本地文件的管理类，为文件下载，日志记录，以及图片等的保存提供管理支持
 *
 */
public class LocalFileManager {
	/**
	 * 位于SD卡上的文件保存的根路径
	 */
    public final static String BASE_DIR = "/founder_media";
    /**
     * 保存下载中的报刊（xeb）文件。（可能会不完整）
     */
    private final static String PATH_DOWNLOAD = "/download";
    /**
     * 保存报刊的封面图，已经工程中需要保存的图片的路径
     */
    private final static String PATH_IMAGE = "/image";
    /**
     * 保存下载完成后的（xeb）文件，（已经是完整的文件）
     */
    private final static String PATH_XEB = "/xeb";
    /**
     * 保存升级包的目录
     */
    private final static String PATH_UPDATE_CACHE = "/update";

    /**
     * 保存下载中的报刊（xeb）文件。（可能会不完整）
     */
    public static final String PATH_KEY_DOWNLOAD = "key_download";
    /**
     * 保存报刊的封面图，已经工程中需要保存的图片的路径
     */
    public static final String PATH_KEY_IMAGE = "key_image";
    /**
     * 保存下载完成后的（xeb）文件，（已经是完整的文件）
     */
    public static final String PATH_KEY_XEB = "key_xeb";
    /**
     * 保存升级包的目录
     */
    public static final String PATH_KEY_UPDATE_CACHE = "key_update";
    
    private static LocalFileManager mInstance;
    private static String mBaseDir;
    private LocalFileManager() {
    	initSoftDir();
	}
	
    /**
     * 单例获取程序
     * @return 本地文件管理类单例
     */
    public static LocalFileManager instance(){
    	synchronized(LocalFileManager.class){
    		if(mInstance == null){
    			mInstance = new LocalFileManager();
    			mBaseDir = Environment.getExternalStorageDirectory() + BASE_DIR;
    		}
    		return mInstance;
    	}
    }
    
    /**
     * 生成缓存文件路径（经过md5摘要）
     * @param pathKey 文件路径的key： PATH_KEY_DOWNLOAD PATH_KEY_IMAGE PATH_KEY_XEB PATH_KEY_UPDATE_CACHE
     * @param netFileUrl 文件的网络地址（内部经过md5摘要，已经不同于原始文件名）
     * @return 对应的文件路径组合。
     */
    public String createCachedFilePath(String pathKey, String netFileUrl){
    	StringBuffer sb = new StringBuffer();
    	sb.append(getPath(pathKey));
    	sb.append(File.separator);
//    	sb.append(Utility.getMD5Str(netFileUrl));
    	return sb.toString();
    }
    
    /**
     * 生成文件路径
     * @param pathKey 文件路径的key： PATH_KEY_DOWNLOAD PATH_KEY_IMAGE PATH_KEY_XEB PATH_KEY_UPDATE_CACHE
     * @param fileName 文件名
     * @return 生成的本地文件路径。
     */
    public static String createFilePath(String pathKey, String fileName){
    	return getPath(pathKey) + "/" + fileName;
    }
    
    /**
     * 获取对应key值的文件路径
     * @param pathKey PATH_KEY_DOWNLOAD PATH_KEY_IMAGE PATH_KEY_XEB PATH_KEY_UPDATE_CACHE
     * @return 对应key值的文件路径
     */
    public static String getPath(String pathKey){
    	StringBuffer sb = new StringBuffer();
    	sb.append(mBaseDir);
    	if(PATH_KEY_DOWNLOAD.equals(pathKey)){
    		sb.append(PATH_DOWNLOAD);
    	}
    	else if(PATH_KEY_IMAGE.equals(pathKey)){
    		sb.append(PATH_IMAGE);
    	}
    	else if(PATH_KEY_XEB.equals(pathKey)){
    		sb.append(PATH_XEB);
    	}
    	else if(PATH_KEY_UPDATE_CACHE.equals(pathKey)){
    		sb.append(PATH_UPDATE_CACHE);
    	}
    	return sb.toString();
    }
    
    /**
     * 清除指定路径下的保存文件
     * @param pathKey ： PATH_KEY_DOWNLOAD PATH_KEY_IMAGE PATH_KEY_XEB PATH_KEY_UPDATE_CACHE
     */
    public void clearPath(String pathKey){
    	String filePath = getPath(pathKey);
    	if(TextUtils.isEmpty(filePath)){
    		return;
    	}
    	File f = new File(filePath);    
        File[] files = f.listFiles();
        if(files != null)  
        {    
            int count = files.length;// 文件个数    
            for (int i = 0; i < count; i++)   
            {    
                File file = files[i];    
                file.delete();
            }    
        }    
    }

    /**
     * 初始化全部预定义好的文件路径
     */
    private void initSoftDir() {
        if (!FileUtil.isExternalStorageAvailable() && !FileUtil.externalStorageWriteable()) {
//            Log.e("The external storage is not available or writeable while init the soft dir!");
            return;
        }
        initPath(PATH_DOWNLOAD);
        initPath(PATH_IMAGE);
        initPath(PATH_XEB);
        initPath(PATH_UPDATE_CACHE);
    }


    /**
     * 初始化定义好的文件路径
     * @param path 文件路径： PATH_DOWNLOAD PATH_IMAGE PATH_XEB PATH_UPDATE_CACHE
     */
    private void initPath(String path) {
        if (TextUtils.isEmpty(path))
            return;
        
        File root = Environment.getExternalStorageDirectory();
        File file = new File(root + BASE_DIR + path);
        if (!file.exists()) {
            boolean result = file.mkdirs();
            if (result) {
//                Log.i(">>>>> success to create the file save path (" + path  + ") -> " + file.getAbsolutePath());
            } else {
//                Log.i(">>>>> failure to create the file save path (" + path + ")  -> " + file.getAbsolutePath());
            }
        }
    }
}