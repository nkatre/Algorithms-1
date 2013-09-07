
public class ExcelColumn {
	
	public static String getExcelColumn(int number) throws Exception
	{
		if(number >= 1 && number <= 26) {
			char c = (char) (65 + number - 1);
			String letter = Character.toString(c);
			return letter;
		} else {
			return getExcelColumn(number/26) + getExcelColumn(number%26);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(ExcelColumn.getExcelColumn(27));
	}
	
}
