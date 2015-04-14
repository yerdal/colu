package ship;

public class FuelOilPerformance
{
	private int baselineID;
	private String baselineSelected;
	private String baselineOvaConsPerformance;
	private String baselineOvaConsPerformanceRepDiff;
	private String baselineOvaConsPerformanceRepDiffPrcnt;
	private String baselinePvaConsPerformance;
	private String baselinePvaConsPerformanceRepDiff;
	private String baselinePvaConsPerformanceRepDiffPrcnt;

	public FuelOilPerformance(int theBaselineID,
								String theBaselineSelected,
								String theBaselineOvaConsPerformance,
								String theBaselineOvaConsPerformanceRepDiff,
								String theBaselineOvaConsPerformanceRepDiffPrcnt,
								String theBaselinePvaConsPerformance,
								String theBaselinePvaConsPerformanceRepDiff,
								String theBaselinePvaConsPerformanceRepDiffPrcnt)
	{
		baselineID = theBaseLineID;
		baselineSelected = theBaselineSelected;
		baselineOvaConsPerformance = theBaseLineOvaConsPerformance;
		baselineOvaConsPerformance = theBaseLineOvaConsPerformance;
		baselineOvaConsPerformanceRepDiff = theBaselineOvaConsPerformanceRepDiff;
		baselineOvaConsPerformanceRepDiffPrcnt = theBaselineOvaConsPerformanceRepDiffPrcnt;
		baselinePvaConsPerformance = theBaselinePvaConsPerformance;
		baselinePvaConsPerformanceRepDiff = theBaselinePvaConsPerformanceRepDiff;
		baselinePvaConsPerformanceRepDiffPrcnt = theBaselinePvaConsPerformanceRepDiffPrcnt;
	}

	public int getBaseLineID()
	{
		return baselineID;
	}
	public String getBaselineSelected()
	{
		return baselineSelected;
	}
	public String getBaselineOvaConsPerformance()
	{
		return baselineOvaConsPerformance;
	}
	public String getBaselineOvaConsPerformanceRepDiff()
	{
		return baselineOvaConsPerformanceRepDiff;
	}
	public String getBaselineOvaConsPerformanceRepDiffPrcnt()
	{
		return baselineOvaConsPerformanceRepDiffPrcnt;
	}
	public String getBaselineOvaConsPerformance()
	{
		return baselinePvaConsPerformance;
	}
	public String getBaselinePvaConsPerformanceRepDiff()
	{
		return baselinePvaConsPerformanceRepDiff
	}
	public String getBaselinePvaConsPerformanceRepDiffPrcnt()
	{
		return baselinePvaConsPerformanceRepDiffPrcnt;
	}

}