package racingCar.service;

import racingCar.domain.CarDTO;
import racingCar.repository.CarRepository;

import java.util.*;

public class CarService {
    private static final int RANDOM_NUM_UPPER_BOUND = 10;
    private static final int FORWARD_NUM_LOWER_BOUND = 4;
    private final CarRepository carRepository;

    /**
     * CarConfig로 부터 repository 객체를 가져와 의존성 주입
     * @param carRepository
     */
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;                     // DI
    }

    /**
     * 입력 받은 문자열을 통해 자동차 객체들 생성 및 저장
     * @param carNames
     */
    public void saveCars(String carNames) {
        List<String> nameList = splitCarNames(carNames);        // 입력된 문자열을 콤마(,) 기준 분리
        for(String name : nameList) {
            carRepository.save(new CarDTO(name));               // 이름을 통해 객체 생성
        }
    }

    /**
     * 입력 받은 문자열의 공백을 제거 후, 콤마로 split하여 List로 반환
     * @param carNames
     * @return name list
     */
    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(
                carNames.replaceAll("\\s+","")  // 공백 제거
                .split(",")
        );
    }

    /**
     * 경주의 각 라운드를 수행하는 메서드
     * 난수를 생성하고 전진하거나 정지한다
     */
    public void playRound() {
        List<CarDTO> carDTOList = carRepository.findAll();       // 모든 객체를 가져옴
        for(CarDTO car : carDTOList) {
            int randomNum = generateRandomNumber();             // 난수 생성
            if(canForward(randomNum)) {                         // 만약 전진이 가능하다면 자동차의 position을 1 더함
                car.increasePos();
            }
        }
    }

    /**
     * 자동차가 전진할 수 있는지 판단하는 메서드
     * @param randomNum 생성된 난수
     * @return 난수가 하한 값보다 크거나 같다면 true 반환
     */
    private boolean canForward(int randomNum) {
        return randomNum >= FORWARD_NUM_LOWER_BOUND;
    }

    /**
     * 범위 내의 정수 난수를 생성하여 반환하는 메서드
     * @return 0 이상 상한 값 미만의 난수를 반환
     */
    private int generateRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());             // seed 설정
        return random.nextInt(RANDOM_NUM_UPPER_BOUND);
    }

    /**
     * 최종 우승자를 리스트로 반환하는 메서드
     * @return 최종 우승자가 저장된 List
     */
    public List<CarDTO> getWinner() {
        int maxPos = getMaxPos();

        List<CarDTO> carDTOList = carRepository.findAll();      // 모든 객체 리스트
        return carDTOList
                .stream()
                .filter(carDTO -> carDTO.getPos() == maxPos)    // pos가 가장 큰 객체들을 선택하여 반환
                .toList();
    }

    /**
     * 객체 중 가장 큰 pos의 값을 반환
     * @return max pos
     */
    private int getMaxPos() {
        return carRepository
                .findOneMaxPos()
                .orElseThrow(NullPointerException::new)
                .getPos();
    }

    /**
     * Repository의 전체 객체 리스트를 controller에게 반환하기 위한 용도의 메서드
     * @return Car instance list
     */
    public List<CarDTO> getAllCars() {
        return carRepository.findAll();
    }
}
