package app.dmo.gradletest.app;

import app.dmo.gradletest.model.TrainTime;
import app.dmo.gradletest.service.TrainTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaxiRailController {

    private final TrainTimeService trainTimeService;

    @Autowired
    public MaxiRailController(final TrainTimeService trainTimeService) {
        this.trainTimeService = trainTimeService;
    }


    @GetMapping(path = "/")
    public List<TrainTime> getTimes() {
        return trainTimeService.getTrainTimes();
    }
}
