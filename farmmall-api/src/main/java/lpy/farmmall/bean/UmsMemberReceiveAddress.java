package lpy.farmmall.bean;



import javax.persistence.Id;

public class UmsMemberReceiveAddress {

    @Id
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