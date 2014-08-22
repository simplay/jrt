package jrt.jrt;

public class App {

	public static void main(String[] args) {
		String formatPattern = "(-\\w\\s\\d*\\s)+(-\\w\\s\\d*)";	
		int width = -1; int height = -1; int task = -1;
		
		try {
			if(concatinateStrings(args).replaceFirst(formatPattern, "").length() != 0) {
				throw new Exception("wrong input pattern");
			}

			
			safeIntAssignment(args, "-w", width);
			safeIntAssignment(args, "-h", height);
			safeIntAssignment(args, "-t", task);
			
			System.out.println("Stating rendering process...");
			new Renderer(width, height, task);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("example input: -w 10 -h 10 -t 1");
		}
		
	}
	
	/**
	 * Concatenated String of given String array separated by empty string
	 * @param strings array containing words
	 * @return concatenated word
	 */
	public static String concatinateStrings(String[] strings) {
		String concatinatedString = "";
		for (String string : strings) {
			concatinatedString += string + " ";
		}
		return concatinatedString.substring(0, concatinatedString.length()-1);
	}
	
	/**
	 * Assigns target variable with value determined by paramId if is not null
	 * @param args input arguments
	 * @param paramId parameter identifier in format /^-\w$/
	 * @param target target variable
	 * @throws Exception containing error
	 */
	public static void safeIntAssignment(String[] args, String paramId, int target) throws Exception{
		try{
			String value = getValueAt(args, paramId);
			target = Integer.parseInt(value);
		} catch (Exception e) {
			throw new Exception("null INT assignment for " + paramId);
		}
	}
	
	/**
	 * Find value in collection of provided index cdx
	 * @param collection String array in format {cdx, value}*
	 * @param cdx String identifier indicating a parameter's name
	 * @return Null or String value of corresponding cdx identifier.
	 */
	public static String getValueAt(String[] collection, String cdx) {
		int idx = 0;
		for(String item : collection) {
			if(item.equals(cdx)) {
				return collection[idx+1];
			}
			idx++;
		}
		return null;
	}
}