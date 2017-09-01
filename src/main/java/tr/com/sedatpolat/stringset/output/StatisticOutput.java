package tr.com.sedatpolat.stringset.output;

/**
 * 
 * @author sedpol
 *
 */
public class StatisticOutput extends BaseOutput {
	private static final long serialVersionUID = 1L;

	private Integer numberOfString;
	private Integer lengthOfTheShortestString;
	private Integer lengthOfTheLongestString;
	private Double averageLength;
	private Double medianLength;
	
	public Integer getNumberOfString() {
		return numberOfString;
	}
	public void setNumberOfString(Integer numberOfString) {
		this.numberOfString = numberOfString;
	}
	public Integer getLengthOfTheShortestString() {
		return lengthOfTheShortestString;
	}
	public void setLengthOfTheShortestString(Integer lengthOfTheShortestString) {
		this.lengthOfTheShortestString = lengthOfTheShortestString;
	}
	public Integer getLengthOfTheLongestString() {
		return lengthOfTheLongestString;
	}
	public void setLengthOfTheLongestString(Integer lengthOfTheLongestString) {
		this.lengthOfTheLongestString = lengthOfTheLongestString;
	}
	public Double getAverageLength() {
		return averageLength;
	}
	public void setAverageLength(Double averageLength) {
		this.averageLength = averageLength;
	}
	public Double getMedianLength() {
		return medianLength;
	}
	public void setMedianLength(Double medianLength) {
		this.medianLength = medianLength;
	}
	
	@Override
	public String toString() {
		return "StatisticOutput [numberOfString=" + numberOfString + ", lengthOfTheShortestString="
				+ lengthOfTheShortestString + ", lengthOfTheLongestString=" + lengthOfTheLongestString
				+ ", averageLength=" + averageLength + ", medianLength=" + medianLength + "]";
	}
	
}
