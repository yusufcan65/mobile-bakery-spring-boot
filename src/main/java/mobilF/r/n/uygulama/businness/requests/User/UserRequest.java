package mobilF.r.n.uygulama.businness.requests.User;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type")

@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomerRequest.class, name = "Customer"),
        @JsonSubTypes.Type(value = ManagerRequest.class, name = "Manager"),
        @JsonSubTypes.Type(value = SellerRequest.class, name = "Seller"),
})
public interface UserRequest {
     String name=null;
     String surname=null;
     String username=null;
     String password=null;
}
