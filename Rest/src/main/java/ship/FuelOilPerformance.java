package ship;

/**
 * Class to represent the fuil and oil performance of a ship
 */

public class FuelOilPerformance
{
	//baseline = måttstock(?)
	private int baselineID; // måttID?
	private String baselineSelected; // valt eller inte valt? oklart.
	private double baselineOvaConsPerformance; //Calculated main engine fuel oil consumption according to baseline. unit: metric tonnes per day
	private double baselineOvaConsPerformanceRepDiff; //Calculated difference between reported main engine fuel oil consumption and baseline. unit: metric tonnes per day
	private double baselineOvaConsPerformanceRepDiffPrcnt; //Calculated difference between reported main engine fuel oil consumption and baseline. unit: percent
	private double baselinePvaConsPerformance; //Calculated main engine fuel oil consumption according to baseline. unit: metric tonnes per day
	private double baselinePvaConsPerformanceRepDiff; //Analysed difference between reported main engine fuel oil consumption and baseline. unit: metric tonnes per day
	private double baselinePvaConsPerformanceRepDiffPrcnt; //Analysed difference between reported main engine fuel oil consumption and baseline. unit: percent

	public FuelOilPerformance(int theBaseLineID,
								String theBaselineSelected,
								double theBaselineOvaConsPerformance,
								double theBaselineOvaConsPerformanceRepDiff,
								double theBaselineOvaConsPerformanceRepDiffPrcnt,
								double theBaselinePvaConsPerformance,
								double theBaselinePvaConsPerformanceRepDiff,
								double theBaselinePvaConsPerformanceRepDiffPrcnt)
	{
		baselineID = theBaseLineID;
		baselineSelected = theBaselineSelected;
		baselineOvaConsPerformance = theBaselineOvaConsPerformance;
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
	public double getBaselineOvaConsPerformance()
	{
		return baselineOvaConsPerformance;
	}
	public double getBaselineOvaConsPerformanceRepDiff()
	{
		return baselineOvaConsPerformanceRepDiff;
	}
	public double getBaselineOvaConsPerformanceRepDiffPrcnt()
	{
		return baselineOvaConsPerformanceRepDiffPrcnt;
	}
	public double getBaselinePvaConsPerformance()
	{
		return baselinePvaConsPerformance;
	}
	public double getBaselinePvaConsPerformanceRepDiff()
	{
		return baselinePvaConsPerformanceRepDiff;
	}
	public double getBaselinePvaConsPerformanceRepDiffPrcnt()
	{
		return baselinePvaConsPerformanceRepDiffPrcnt;
	}

}