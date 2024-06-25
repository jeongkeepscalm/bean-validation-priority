package bean.validation.priority.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@Slf4j
public class PriorityController {

  @PostMapping("/test")
  public Object priorityTest(@Validated(ValidationSequence.class) @RequestBody PriorityRequest priorityRequest, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return bindingResult.getAllErrors()
              .stream()
              .map(v -> v.getDefaultMessage())
              .collect(Collectors.toList());
    }
    return "no error";
  }

}
