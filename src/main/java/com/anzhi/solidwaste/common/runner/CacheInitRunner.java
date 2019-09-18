package com.anzhi.solidwaste.common.runner;

import com.anzhi.solidwaste.common.exception.RedisConnectException;
import com.anzhi.solidwaste.common.service.CacheService;
import com.anzhi.solidwaste.enterprise.dto.WasteCategoryDto;
import com.anzhi.solidwaste.enterprise.entity.WasteCategory;
import com.anzhi.solidwaste.enterprise.service.WasteCategoryService;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.manager.UserManager;
import com.anzhi.solidwaste.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @author andy
 * @date 2019/7/3 14:47
 */
@Slf4j
@Component
public class CacheInitRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @Autowired
    private ConfigurableApplicationContext context;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            log.info("Redis连接中 ······");
            cacheService.testConnect();

            log.info("缓存初始化 ······");
            log.info("缓存危废目录数据 ······");

            List<WasteCategoryDto> result = this.wasteCategoryService.getAllCategories();
           // redisTemplate.opsForHash().putAll("wmap", result);
            this.cacheService.saveWasteCategories(result);
            // List<User> list = this.userService.list(new LambdaQueryWrapper<User>().eq(User::getIsReview, 0));
            // List<User> list = this.userService.findAllUsers();
            // userManager.loadUserList(list);
            //
            // for (User user : list) {
            //     userManager.loadUserRedisCache(user);
            // }
        } catch (Exception e) {
            log.error("缓存初始化失败，{}", e.getMessage());
            log.error(" ____   __    _   _ ");
            log.error("| |_   / /\\  | | | |");
            log.error("|_|   /_/--\\ |_| |_|__");
            log.error("                        ");
            log.error("AZ_WATERSTATION启动失败              ");
            if (e instanceof RedisConnectException)
                log.error("Redis连接异常，请检查Redis连接配置并确保Redis服务已启动");
            // 关闭
            context.close();
        }
    }
}
