package makers.domain.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue(value = UserType.Values.MAKERS)
public class MakersUser extends User{
	private String password;
	@Transient
	private String rawPassword;
	
	public MakersUser(){
	}
	
	public MakersUser(String userId, String email, String organization, String password){
		super(userId, email, organization);
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void encodePassword(PasswordEncoder passwordEncoder) {
		System.out.println("raw="+rawPassword);
		this.password = passwordEncoder.encode(rawPassword);
	}
}