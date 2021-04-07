import java.io.*;

public class StudyContentsInfo implements Serializable
{
	private StringBuilder codeSection;
	private StringBuilder annotationSection;

	public StudyContentsInfo()
	{
		this.codeSection = new StringBuilder("");
		this.annotationSection = new StringBuilder("");
	}
	public StudyContentsInfo(StringBuilder codeSection, StringBuilder annotationSection)
	{
		this.codeSection = codeSection;
		this.annotationSection = annotationSection;
	}
	
	public void setCodeSection(StringBuilder codeSection)
	{
		this.codeSection = codeSection;
	}
	public void setAnnotationSection(StringBuilder annotationSection)
	{
		this.annotationSection = annotationSection;
	}

	public StringBuilder getCodeSection()
	{
		return this.codeSection;
	}
	public StringBuilder getAnnotationSection()
	{
		return this.annotationSection;
	}

	public String toString()
	{
		String str = "\n �ڵ� : " + codeSection + "\n ���� : " + annotationSection;
		return str;
	}
}
