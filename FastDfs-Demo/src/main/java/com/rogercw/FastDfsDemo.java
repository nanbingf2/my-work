package com.rogercw;

import org.csource.fastdfs.*;

/**
 * @Author: rogercw
 * @Date: 2018/8/11 15:36
 * @Version 1.0
 */
public class FastDfsDemo {

    public static void main(String args[]) throws Exception {
        //1:加载fastDfs的配置文件
        ClientGlobal.init("C:\\Users\\Administrator\\Desktop\\IDEA\\my-work\\FastDfs-Demo\\src\\main\\resources\\fdfs_client.conf");

        //2:创建一个TrackerClient对象：直接new一个
        TrackerClient trackerClient=new TrackerClient();

        //3:使用TrackerClient对象创建连接，获得一个TrackerServer对象
        TrackerServer trackerServer = trackerClient.getConnection();

        //4:创建一个StorageServer的引用
        StorageServer storageServer=null;

        //5:创建一个对象，需要两个参数：
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);

        //6:使用StorageClient对象完成图片上传
        String[] strings = storageClient.upload_file("C:\\Users\\Administrator\\Desktop\\user-02.jpg", "jpg", null);

        //返回数组：包含组名和图片的路径
        for(String str:strings){
            System.out.println(str);
        }
    }

}
