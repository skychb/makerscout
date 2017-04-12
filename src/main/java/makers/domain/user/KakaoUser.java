package makers.domain.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = UserType.Values.KAKAO)
public class KakaoUser extends User{
	private String name;
	private String accessToken;
	
	public KakaoUser(){

	}
	
	public KakaoUser(String userId, String email, String organization, String name, String accessToken){
		super(userId, email, organization);
		this.name = name;
		this.accessToken = accessToken;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAccessToken(){
		return accessToken;
	}
}
