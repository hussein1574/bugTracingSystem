
package bug_tracing_system;

import java.util.Date;



public class data 
{            
    private String ProjectName;
    private int TesterId;
    private int BugId;
    private String BugName;
    private String BugType;
    private String Priorty;
    private String Statue;
    private String BugDetails;
    private int DeveloperId;
    private String ImageFileName;

    public data() {
    }





    public String getBugDetails() {
        return BugDetails;
    }

    public void setBugDetails(String BugDetails) {
        this.BugDetails = BugDetails;
    }

    public int getTesterId() {
        return TesterId;
    }

    public void setTesterId(int TesterId) {
        this.TesterId = TesterId;
    }

    public int getBugId() {
        return BugId;
    }

    public void setBugId(int BugId) {
        this.BugId = BugId;
    }

    public int getDeveloperId() {
        return DeveloperId;
    }

    public void setDeveloperId(int DeveloperId) {
        this.DeveloperId = DeveloperId;
    }




    public String getImageFileName() {
        return ImageFileName;
    }

    public void setImageFileName(String ImageFileName) {
        this.ImageFileName = ImageFileName;
    }
    

        public  void setProjectName(String ProjectName) {
            this.ProjectName = ProjectName;
        }

        public void setBugName(String BugName) {
            this.BugName = BugName;
        }

        public void setBugType(String BugType) {
            this.BugType = BugType;
        }

        public void setPriorty(String Priorty) {
            this.Priorty = Priorty;
        }

 



        public void setStatue(String Statue) {
            this.Statue = Statue;
        }

    public String getProjectName() {
        return ProjectName;
    }

    public String getBugName() {
        return BugName;
    }

    public String getBugType() {
        return BugType;
    }

    public String getPriorty() {
        return Priorty;
    }

 

    public String getStatue() {
        return Statue;
    }

       
    }