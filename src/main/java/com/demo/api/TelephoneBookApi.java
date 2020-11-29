package com.demo.api;

import com.demo.DataCaches;
import com.demo.Exception.LogicException;
import com.demo.model.ApiCode;
import com.demo.model.Contact;
import com.demo.model.Response;
import com.demo.utils.ResultBuilder;
import com.demo.utils.validatorgroup.ModifyCheck;
import com.demo.utils.validatorgroup.SaveCheck;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

/**
 * 联系人 controller
 */
@RestController
@RequestMapping("/phoneBook")
public class TelephoneBookApi {

    /**
     * 联系人列表
     *
     * @return
     */
    @GetMapping
    public Response findAll() {
        return ResultBuilder.success(DataCaches.findAll());
    }

    /**
     * 查找联系人
     *
     * @param contact
     * @return
     */
    @GetMapping("/all")
    public Response find(Contact contact) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return ResultBuilder.success(DataCaches.findByNameOrPhoneNumber(contact));
    }

    /**
     * 保存联系人
     *
     * @param contact
     * @return
     */
    @PostMapping
    public Response save(@RequestBody @Validated(value = {SaveCheck.class}) Contact contact) {
        DataCaches.save(contact);
        return ResultBuilder.success();
    }

    /**
     * 修改联系人
     *
     * @param contact
     * @return
     */
    @PutMapping
    public Response modify(@RequestBody @Validated(value = {ModifyCheck.class}) Contact contact) throws LogicException {
        boolean result = DataCaches.modify(contact);
        if (result) {
            return ResultBuilder.success();
        } else {
            return ResultBuilder.failure(ApiCode.FAILURE, "联系人不存在");
        }
    }

    /**
     * 删除联系人
     *
     * @param id
     * @return
     * @throws LogicException
     */
    @DeleteMapping
    public Response remove(@RequestParam("id") String id) throws LogicException {
        if (StringUtils.isEmpty(id)) {
            throw new LogicException("标识不能为空");
        }
        boolean result = DataCaches.remove(id);
        if (result) {
            return ResultBuilder.success();
        } else {
            return ResultBuilder.failure(ApiCode.FAILURE, "联系人不存在");
        }
    }
}
