package com.chentian.expenses.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * ��֤��(��д��ĸ��Сд��ĸ�����֡�����)
 * ��б�����ƽ���Ѷ�
 */
@Controller
public class CodeController{

	/** ������֤��ͼƬ�Ŀ�� */
	private static final int IMG_WIDTH = 100;
	/** ������֤��ͼƬ�ĸ߶� */
	private static final int IMG_HEIGHT = 40;
	/** ����һ��Random���� */
	private static Random random = new Random();
	/** ����������� */
	private static Font font = new Font("����", Font.BOLD, 18);
	
	@RequestMapping("/createCode")
	public void createImg(HttpServletResponse response,HttpSession session) throws IOException{
		
		/** ������Ӧ���������� */
		response.setContentType("images/jpeg");
		/** ����һ��ͼƬ���������� (����) */
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		/** ��ȡ������ */
		Graphics g = image.getGraphics();
		/** ���һ�����ο� */
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		/** ���û��ʵ���ɫ */
		g.setColor(Color.BLACK);
		/** ����һ�����ο� */
		g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGHT - 1);
		/** ���Ƹ����� */
		for (int i = 0; i < 50; i++){
			/** ���û��ʵ���ɫ(��ɫ���������) */
			g.setColor(new Color(180 + random.nextInt(75), 
								 180 + random.nextInt(75),
								 180 + random.nextInt(75)));
			// ��һ��
			int x1 = 2 + random.nextInt(IMG_WIDTH - 4);
			int y1 = 2 + random.nextInt(IMG_HEIGHT - 4);
			// �ڶ���
			int x2 = 2 + random.nextInt(IMG_WIDTH - 4);
			int y2 = 2 + random.nextInt(IMG_HEIGHT - 4);
			g.drawLine(x1, y1, x2, y2);
		}
		
		/** ������֤��(��������ĸ���֤��) */
		g.setFont(font); // ��������
		String code = ""; // �����������ɵ���֤��
		for (int i = 0; i < 4; i++){
			String temp = generatorVerify();
			code += temp;
			/** ���û��ʵ���ɫ(��ɫ���������) */
			g.setColor(new Color(random.nextInt(20), 
								 random.nextInt(40),
								 random.nextInt(20)));
			
			int offsetLeft = transferFrom(g);
			
			g.drawString(temp, 13 * i + offsetLeft, 17);
		}
		System.out.println(code);
		//��֤�����ɺ�֮����Ҫ�����session��
		session.setAttribute("vcode", code);
		/** ���ٻ��� */
		g.dispose();
		/** ���     �����ɺõ�ͼƬ��Ӧ�������*/
		ImageIO.write(image, "jpeg", response.getOutputStream());
		
	}
	/**
	 * ����λ����б����
	 * @param g
	 * @return
	 */
	private int transferFrom(Graphics g) {
		Graphics2D gr = (Graphics2D)g;
		AffineTransform tr =  gr.getTransform();
		// ���������б��
		double shx = Math.random();
		// ��֤��б����(0.25-0.55)֮��
		if (shx < 0.25) shx = 0.25;
		if (shx > 0.55) shx = 0.55;
		// �������������б
		int temp = random.nextInt(2);
		int offsetLeft = 2;
		if (temp == 0){
			shx = 0 - shx;
			offsetLeft = 10;
		}
		tr.setToShear(shx, 0);
		gr.setTransform(tr);
		return offsetLeft;
	}
	/**
	 * �������һ����֤��(��д��ĸ��Сд��ĸ�����֡�����)
	 * @return
	 */
	private String generatorVerify(){
		/** �������0-3֮������� */
		int witch = (int)Math.round((Math.random() * 2));
		//witch = 2;
		switch (witch){
			case 0: // ���ɴ�д��ĸ(A-Z|65-90)
				long temp = Math.round(Math.random() * 25 + 65);
				return String.valueOf((char)temp);
			case 1: // ����Сд��ĸ(a-z|97-122)
				temp = Math.round(Math.random() * 25 + 97);
				return String.valueOf((char)temp);
			case 2: // ��������(0-9)
				return String.valueOf(Math.round(Math.random() * 9));
			default: // ���ɺ���(0x4E00-0x9FBF)
				temp = Math.round(Math.random() * 500 + 0x4E00);
				return String.valueOf((char)temp);
		}
	}
	
	public void setRandom(String random){}
}