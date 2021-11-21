package com.cloth.clothfrontweb.commonmodel.domain.response;
import com.cloth.clothfrontweb.commonmodel.domain.Designer;
import com.cloth.clothfrontweb.commonmodel.domain.Magazine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DesignerList {
    private String surface;
    private String surfaceIntroduce;
    private String surfaceTopic;
    private String comment;
    private int id;
    private String type;
    private String name;
    private String time;
   public DesignerList(Designer designer, Magazine magazine){
            this.surface=designer.getSurface();
            this.surfaceTopic = designer.getSurfaceTopic();
            this.surfaceIntroduce = designer.getSurfaceIntroduce();
            this.comment=designer.getComment();
            this.id = designer.getId();
            this.name = magazine.getName();
            this.time = magazine.getTime();
            this.type=designer.getType();

    }
}
