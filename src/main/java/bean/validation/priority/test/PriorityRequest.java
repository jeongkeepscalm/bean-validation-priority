package bean.validation.priority.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
public class PriorityRequest {

  @Builder
  @JsonCreator // 역직렬화 생성자를 명시적으로 정의. @Builder 어노테이션과 함께 사용할 때 유용
  public PriorityRequest(String email) {
    this.email = email;
  }

  @NotBlank(groups = ValidationGroups.Second.class, message = "빈문자 허용 x")
  @Email(groups = ValidationGroups.Third.class,
          regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "이메일 형식에 맞게 입력")
  @Size(groups = ValidationGroups.First.class,
          min = 3, max = 10, message = "3 ~ 10 문자")
  private String email;

  /**
   * @NotBlank: 빈문자 & 공백 & null 허용하지 않는다.
   */
}
