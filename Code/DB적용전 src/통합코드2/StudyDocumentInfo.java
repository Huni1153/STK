import java.util.Date;
import java.io.*;

public class StudyDocumentInfo implements Serializable
{
	private String documentCode;
	private String documentName;
	private Date documentDate; // ����,�����ð�
	private String documentDirectory; // ���ϸ�
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
			+ "\n----------------------\n";
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
	
	public void �˻��Ѵ�<�ҷ��� �н������� �ִ�����, ���� ��¥�� ��������>() {
	
	}
	
	public void �˻��Ѵ�<�Է¹��� �н����� ������>() {
	
	}
	
	public void �����ϴ�<�н�������>() {
	
	}
	
	public void �����Ѵ�<�ĺ��ڵ带>() {
	
	}
	
	public void ��û�ϴ�<�н����� ���� �Է�>() {
	
	}
	
	public void ��û�ϴ�<�н����� ���� ���� �Է�>() {
	
	}
	
	public void ��û�Ѵ�<�н����� ������ ��ġ �Է���>() {
	
	}
	
	public void ��û�Ѵ�<�н����� ������ ���� �Է���>() {
	
	}
	
	public void ��û�Ѵ�<�н������� �Է���>() {
	
	}
	
	public void ��ȿ�ϴ�<�н���������>() {
	
	}
	
	public void �����ϴ�<�н����� ������>() {
	
	}
	
	public void �����Ѵ�<�н����� ������>() {
	
	}
	
	public void �����ϴ�<�н����� �ĺ���ȣ��>() {
	
	}
	*/
}
