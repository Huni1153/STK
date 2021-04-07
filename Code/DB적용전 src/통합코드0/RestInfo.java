public class RestInfo
{
	private int studyTime;
	private int practiceTime;
	private int designTime;
	private double restIndex;

	public RestInfo()
	{
	}
	public RestInfo(int studyTime,int practiceTime,int designTime,double restIndex)
	{
	}
	public void setStudyTime(int studyTime)
	{
		this.studyTime=studyTime;
	}
	public void setPracticeTime(int practiceTime)
	{
		this.practiceTime=practiceTime;
	}
	public void setDesignTime(int designTime)
	{
		this.designTime=designTime;
	}
	public void setRestIndex(double restIndex)
	{
		this.restIndex=restIndex;
	}
	public int getStudyTime()
	{
		return this.studyTime;
	}
	public int getPracticeTime()
	{
		return this.practiceTime;
	}
	public int getDesignTime()
	{
		return this.designTime;
	}
	public double getRestIndex()
	{
		return this.restIndex;
	}
	public String toString()
	{
		return "";
	}
	public int calcRestIndex()
	{

		return 0;
	}
	public String provideRestIndex()
	{

		return "";
	}
	public int provideRestMessage()
	{

		return 0;
	}
}