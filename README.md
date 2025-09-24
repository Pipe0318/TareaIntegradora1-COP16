# COP16 Biodiversity App 🌿

Academic project developed in **Java** for the course *Algoritmos y Programación*, Universidad Icesi.  
The application was designed around the **COP16 Biodiversity Conference** in Cali, Colombia, and simulates the management of event agendas, biodiversity places, and local communities.  

---

## 📌 Features
- **Agenda management** for COP16 events and eco-routes (date, meeting point, participants, guides, buses required).  
- **Biodiverse places registry** (name, department, area in km²) with ordering and statistics.  
- **Community management**: store information about local communities that protect biodiversity areas.  
- **Species tracking**: up to 50 species per place (flora/fauna, count, pictures).  
- **Reports and queries**:
  - Order places by area (asc).  
  - Identify department with most biodiverse areas.  
  - Communities with critical issues (lack of hospital/school).  
  - Place with the largest number of species.  

---

## 🛠️ Technologies
- **Language:** Java  
- **Paradigm:** Object-Oriented Programming (OOP)  
- **Concepts:** Inheritance, Polymorphism, Interfaces, UML, JavaDoc  
- **Data Structures:** Fixed-size arrays, dynamic containers, matrices  
- **Version Control:** Git / GitHub  

---

## 📂 Project Structure

COP16/
 ├── src/
 │    ├── ui/        # User interface (console)
 │    └── model/     # Core classes (events, places, communities, species)
 ├── bin/            # Compiled .class files
 ├── doc/            # UML diagrams, specifications
 └── README.md

## 🚀 How to Run

### Clone the repository:

git clone https://github.com/Pipe0318/TareaIntegradora1-COP16.git

cd TareaIntegradora1-COP16


### Compile the project:

javac src/model/*.java src/ui/*.java -d bin



### Run the main class:

java -cp bin ui.Main


##📖 Documentation

UML diagrams and JavaDoc are included in the /doc folder.

JavaDoc can be generated with:

javadoc -d doc/API src/model/*.java src/ui/*.java

👥 Authors

Juan @Pipe0318

Universidad Icesi – Ingeniería de Sistemas

📌 License

This project is for academic purposes only.
You are free to use the code for learning and practice.
