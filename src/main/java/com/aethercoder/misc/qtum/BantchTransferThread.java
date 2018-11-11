package com.aethercoder.misc.qtum;

import org.spongycastle.util.encoders.Hex;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

public class BantchTransferThread implements Runnable{

    private QtumService qtumService;

    private Integer peerNum;

    public BantchTransferThread(QtumService qtumService,Integer peerNum){
        this.qtumService = qtumService;
        this.peerNum = peerNum;
    }

    /**
     * 执行方法
     */
    @Override
    public void run() {
//        try {
//            StringBuffer sb = new StringBuffer();
//            FileInputStream fis = new FileInputStream("/Users/wangkai/Documents/蒋介石.txt");
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
//            byte[] buff = new byte[1024];
//            int len = 0;
//            while ((len = fis.read(buff)) != -1) {
//                bos.write(buff, 0, len);
//            }
//            //得到图片的字节数组
//            byte[] result = bos.toByteArray();
//            //字节数组转成十六进制
//            String str = Hex.toHexString(result);
//
//            ByteArrayInputStream bais = new ByteArrayInputStream(Hex.decode(result));
//            BufferedImage bi1 = ImageIO.read(bais);
//            File w2 = new File("/Users/wangkai/Documents/weixinhuihua/images/jiangjieshi2.jpg");// 可以是jpg,png,gif格式
//            ImageIO.write(bi1, "jpg", w2);
//            bais.close();
//        }catch(Exception e){
//        }

        try {
            writeMaxBlockHeight(1000);

            int result = getMinBlockHeight();


            String seedString = "rapid accident album driving blink complain attention participate vehicle hopefully protest crisis";
            long time = System.currentTimeMillis();
            String toAddress = "QWXrSap9kvsoPmq9YrXp87NQQn4utwVqTk";
            String fromAddress = "QRVTEo2tKqje1cDc72amhCodeGvHfz1yKE";

//            for (int i = 0; i < 10000; i++){
//                qtumService.transferByPeerNum(seedString, toAddress, "0.05", "0.04", fromAddress, peerNum);
//            }

//            qtumService.transferByPeerNum(seedString, toAddress, "0.5", "0.04", fromAddress, peerNum);

            String seed = "rapid accident album driving blink complain attention participate vehicle hopefully protest crisis";
            List<String> addressList = qtumService.getOwnerAdderss(seed);
            String contractAddress = "3bce73c33516f178560ae968345bb352c9c0d502";
            qtumService.callContract(seed, "", contractAddress, "0.3", "3ccfd60b", addressList);


            System.out.println("TRANSFER time is" + (System.currentTimeMillis() - time));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private Integer getMinBlockHeight() throws Exception{
        File file = new File("../MissMinBlockHeight.conf");
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s = bReader.readLine()) != null) {
            sb.append(s);//将读取的字符串添加换行符后累加存放在缓存中
        }
        bReader.close();

        return Integer.valueOf(sb.toString());
    }

    private void writeMaxBlockHeight(Integer maxBlockHeight) throws Exception{
        File file =new File("../MissMinBlockHeight.conf");

        //if file doesnt exists, then create it
        if(!file.exists()){
            file.createNewFile();
        }

        //true = append file
        FileWriter fileWritter = new FileWriter(file.getName(),false);
        fileWritter.write(maxBlockHeight.toString());
        fileWritter.close();
    }
}
