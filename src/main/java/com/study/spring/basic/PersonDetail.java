package com.study.spring.basic;

/**
 * @Author milindeyu
 * @Date 2021/12/24 10:04 下午
 * @Version 1.0
 */
public class PersonDetail {
    private String address;
    private String gender;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PersonDetail{" +
                "address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
