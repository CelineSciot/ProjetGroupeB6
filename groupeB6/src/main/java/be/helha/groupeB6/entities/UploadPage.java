package be.helha.groupeB6.entities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.sun.xml.ws.policy.privateutil.PolicyUtils.IO;

@Named
@ViewScoped
public class UploadPage implements Serializable{

	private Part uploadedFile;
	
	public byte[] uploadFile() /*throws IOException*/ {
		InputStream input=null;
		try {
			input = uploadedFile.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] image=null;
		try {
			image = IOUtils.toByteArray(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Apache commons IO.
		return image;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	
	
}
