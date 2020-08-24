package fr.eql.teama.catalogue.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class DeleteResponse {
    private boolean success;
    private String message ;

    public DeleteResponse(boolean success, String message){
        this.success=success;
        this.message=message;
    }

    public static  DeleteResponse withSuccess(String msg){
        return new DeleteResponse(true,msg);
        }

    public static DeleteResponse withError(String msg){
        return new DeleteResponse(false,msg);
        }
}
