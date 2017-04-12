package makers.domain.user;

public enum UserType {
	KAKAO(Values.KAKAO), FACEBOOK(Values.FACEBOOK), MAKERS(Values.MAKERS);
	
	private String type;
	private UserType(String type){
		this.type = type;
	}
	
	public String getType(){
		return type;
	}
	
	public static class Values{
		public static final String KAKAO ="K";
		public static final String FACEBOOK = "F";
		public static final String MAKERS = "M";
	}
}
