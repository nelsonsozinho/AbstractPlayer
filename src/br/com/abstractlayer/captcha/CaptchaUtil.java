package br.com.abstractlayer.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaUtil {

	public static final String CAPTCHA_ID = "EmForge";


	private ImageCaptchaService captchaServices;
	
	private ImageCaptchaService service;
	
	public CaptchaUtil() {
		this.service = CaptchaSingleton.getInstance();
		
	}
	
	/**
	 * Metodo inicial para a utilizacao do servico. O metodo gera uma 
	 * imagem qualquer atrelada ao id da sessao que foi passado 
	 * 
	 * @param sessionId
	 * @return
	 */
	public BufferedImage generateCaptcha(String sessionId) {
		byte[] captchaChalengeAsJpg = null;
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		return service.getImageChallengeForID(sessionId);
	}
	
	/**
	 * Metodo que valida a string com o captcha. O Id da sessao deve ser passado 
	 * para efetuar a validacao do que foi digitado. A validacao é feita de acordo 
	 * com a sessao do usuario
	 * 
	 * @param sessionId
	 * @param valor
	 * @return
	 */
	public Boolean validate(String sessionId, String valor) {
		return service.validateResponseForID(sessionId, valor);
	}
	
	public String getHandleString() {
		String str = new  String("QAa0bcLdUK2eHfJgTP8XhiFj61DOklNm9nBoI5pGqYVrs3CtSuMZvwWx4yE7zR");
		 StringBuffer sb=new StringBuffer();
         Random r = new Random();
         int te=0;
         for(int i=1;i<=6;i++){
             te=r.nextInt(62);
             sb.append(str.charAt(te));
         }        
         return sb.toString();
	}
	
}
