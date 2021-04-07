import java.util.Date;
import java.io.*;

public class StudyDocumentInfo implements Serializable
{
	private String documentCode;
	private String documentName;
	private Date documentDate;
	private String documentDirectory;
	private StudyContentsInfo documentContent;
	private String documentForm;

	public StudyDocumentInfo() {
	
	}
	
	public StudyDocumentInfo(String documentCode, String documentName, Date documentDate, String documentDirectory, StudyContentsInfo documentContent, String documentForm) 
	{
		this.documentCode = documentCode;
		this.documentName = documentName;
		this.documentDate = documentDate;
		this.documentDirectory = documentDirectory;
		this.documentContent = documentContent;
		this.documentForm = documentForm;
	}
	
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	
	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
	
	public void setDocumentDirectory(String documentDirectory) {
		this.documentDirectory = documentDirectory;
	}
	
	public void setDocumentContent(StudyContentsInfo documentContent) {
		this.documentContent = documentContent;
	}

	public void setDocumentContent(StringBuilder codeSection, StringBuilder annotationSection) {
		this.documentContent.setCodeSection(codeSection); 
		this.documentContent.setAnnotationSection(annotationSection); 
	}

	public void setDocumentForm(String documentForm) {
		this.documentForm = documentForm;
	}
	
	public String getDocumentCode() {
		return this.documentCode;
	}
	
	public String getDocumentName() {
		return this.documentName;
	}
	
	public Date getDocumentDate() {
		return this.documentDate;
	}
	
	public String getDocumentDirectory() {
		return this.documentDirectory;
	}
	
	public StudyContentsInfo getDocumentContent() {
		return this.documentContent;
	}

	public String getDocumentForm() {
		return this.documentForm;
	}
	

	public String toString() {
		String str = "DocumentCode : " + documentCode + "\nDocumentName : " + documentName +
			"\nDocumentDate : " + documentDate + "\nDocumentDirectory : " + documentDirectory +
			"\nStudyContentsInfo : " + documentContent + "\nDocumentForm : " + documentForm
			+ "\n----------------------";
		return str;
	}
	
	public Object[] getStudyDocumentInfo() {
		Object[] ary = { documentCode, documentName, documentDate, documentDirectory
		,documentContent, documentForm };

		return ary;
	}
	

	/*
	private void ---------------------------------------------------------------------------------------------------() {
	
	}
	
	public void 검사한다<불러올 학습문서가 있는지를, 현재 날짜를 기준으로>() {
	
	}
	
	public void 검사한다<입력받은 학습문서 정보를>() {
	
	}
	
	public void 수정하다<학습문서를>() {
	
	}
	
	public void 생성한다<식별코드를>() {
	
	}
	
	public void 요청하다<학습문서 내용 입력>() {
	
	}
	
	public void 요청하다<학습문서 수정 내용 입력>() {
	
	}
	
	public void 요청한다<학습문서 저장할 위치 입력을>() {
	
	}
	
	public void 요청한다<학습문서 저장할 형식 입력을>() {
	
	}
	
	public void 요청한다<학습문서명 입력을>() {
	
	}
	
	public void 유효하다<학습문서명이>() {
	
	}
	
	public void 제공하다<학습문서 내용을>() {
	
	}
	
	public void 제공한다<학습문서 정보를>() {
	
	}
	
	public void 지정하다<학습문서 식별번호를>() {
	
	}
	*/
}
