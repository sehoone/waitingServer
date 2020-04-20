package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.domain.User;
import de.jonashackt.springbootvuejs.domain.WaitingBotDetail;
import de.jonashackt.springbootvuejs.domain.WaitingBotInfo;
import de.jonashackt.springbootvuejs.exception.UserNotFoundException;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import de.jonashackt.springbootvuejs.repository.WaitingBotDetailRepository;
import de.jonashackt.springbootvuejs.repository.WaitingBotInfoRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WaitingBotInfoRepository waitingBotInfoRepository;

    @Autowired
    private WaitingBotDetailRepository waitingBotDetailRepository;
    
    @RequestMapping(path = "/hello")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }

    @RequestMapping(path = "/user/{lastName}/{firstName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser (@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        User savedUser = userRepository.save(new User(firstName, lastName));

        LOG.info(savedUser.toString() + " successfully saved into DB");

        return savedUser.getId();
    }

    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new UserNotFoundException("The user with the id " + id + " couldn't be found in the database."));
    }

    @RequestMapping(path="/secured", method = RequestMethod.GET)
    public @ResponseBody String getSecured() {
        LOG.info("GET successfully called on /secured resource");
        return SECURED_TEXT;
    }

    // Forwards all routes to FrontEnd except: '/', '/index.html', '/api', '/api/**'
    // Required because of 'mode: history' usage in frontend routing, see README for further details
    @RequestMapping(value = "{_:^(?!index\\.html|api).*$}")
    public String redirectApi() {
        LOG.info("URL entered directly into the Browser, so we need to redirect...");
        return "forward:/";
    }

    @RequestMapping(path = "/waitCntList")
    public List<WaitingBotDetail> waitCntList() {
        LOG.info("GET called on /waitCntList resource");
        WaitingBotInfo resultInfo = waitingBotInfoRepository.findByLastRow();

        List<WaitingBotDetail> resultDetailList = waitingBotDetailRepository.findBySeqList(resultInfo.getBot_info_seq());
        //List<WaitingBotDetail> resultDetailList = waitingBotDetailRepository.findAll();
        //List<WaitHistory> result = waitRepository.findAll();
        return resultDetailList;
    }

}
