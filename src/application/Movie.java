package application;

public class Movie {
	public String Title;
	public String Year;
	public String imdbID;
	public String Type;
	public String Poster;
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle(String title) {
		this.Title=title;
	}
	
	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		this.Year=year;
	}
	
	public String getimdbID() {
		return imdbID;
	}
	
	public void setimdbID(String imdbID) {
		this.imdbID=imdbID;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		this.Type=type;
	}
	
	public String getPoster() {
		return Poster;
	}
	
	public void setPoster(String poster) {
		this.Poster=poster;
	}
}
