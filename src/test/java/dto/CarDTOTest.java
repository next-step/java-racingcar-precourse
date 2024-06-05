import static org.junit.jupiter.api.Assertions.*;

import DTO.CarDTO;
import org.junit.jupiter.api.Test;

public class CarDTOTest {
  @Test
  public void validCarName() {
    CarDTO carDto = new CarDTO("pobi", 0);
    assertEquals("pobi", carDto.getName());
    assertEquals(0, carDto.getPosition());
  }

  @Test
  public void invalidCarName_Null() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new CarDTO(null, 0);
    });
    assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하이어야 합니다.", exception.getMessage());
  }

  @Test
  public void invalidCarName_Empty() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new CarDTO("", 0);
    });
    assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하이어야 합니다.", exception.getMessage());
  }

  @Test
  public void invalidCarName_TooLong() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new CarDTO("pobipobi", 0);
    });
    assertEquals("[ERROR] 자동차 이름은 1자 이상 5자 이하이어야 합니다.", exception.getMessage());
  }
}
