package workshop.pokerhands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandController {

    @PostMapping("/hands")
    public String postHands(@RequestBody Hand[] hands) {
        return HandService.checkWinner(hands);
    }
}
