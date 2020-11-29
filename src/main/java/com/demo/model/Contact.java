package com.demo.model;

import com.demo.utils.validatorgroup.ModifyCheck;
import com.demo.utils.validatorgroup.SaveCheck;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * 联系人模型
 */
public class Contact {

    @NotBlank(message = "标识不能为空", groups = {ModifyCheck.class})
    private String id;

    /**
     * 联系人姓名
     */
    public String contactName;

    /**
     * 电话号码
     */
    @NotBlank(message = "电话号码不能为空", groups = {SaveCheck.class, ModifyCheck.class})
    public String telephoneNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id) &&
                Objects.equals(contactName, contact.contactName) &&
                Objects.equals(telephoneNumber, contact.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contactName, telephoneNumber);
    }
}
