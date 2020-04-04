package lpy.farmmall.user.Bean;

import lombok.Data;

@Data
public class UmsMemberReceiveAddress {

    private Long id;

    private Long memberId;

    private String name;

    private String phoneNumber;

    private Integer defaultStatus;

    private String postCode;

    private String province;

    private String city;

    private String region;

    private String detailAddress;

}