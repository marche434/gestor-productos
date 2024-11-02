# Variables
SRC_DIR = src
BIN_DIR = bin
DOCS_DIR = docs
MAIN_CLASS = src.aplicacion.Main
JAR_FILE = gestor_productos.jar
MANIFEST_FILE = MANIFEST.MF

# Crear el archivo MANIFEST.MF
manifest:
	echo "Main-Class: $(MAIN_CLASS)" > $(MANIFEST_FILE)
	echo "" >> $(MANIFEST_FILE)  # Línea vacía necesaria en el MANIFEST

# Compilación: compila todos los archivos .java y los coloca en bin/
compile: manifest
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) $(shell find $(SRC_DIR) -name "*.java")

# Crear el archivo JAR utilizando el MANIFEST
jar: compile
	jar cfm $(JAR_FILE) $(MANIFEST_FILE) -C $(BIN_DIR) .

# Generar la documentación Javadoc
javadoc:
	mkdir -p $(DOCS_DIR)
	javadoc -d $(DOCS_DIR) $(shell find $(SRC_DIR) -name "*.java")

# Ejecutar el programa usando el archivo JAR
run: jar
	java -jar $(JAR_FILE)

# Limpiar archivos compilados y el MANIFEST
clean:
	rm -rf $(BIN_DIR)/* $(JAR_FILE) $(MANIFEST_FILE) $(DOCS_DIR)

# Limpiar todos los archivos generados, incluyendo el JAR y el MANIFEST
clean_all: clean
	rm -rf $(BIN_DIR)
	rm -f $(JAR_FILE) $(MANIFEST_FILE)

# Ayuda para ver los comandos disponibles
help:
	@echo "Comandos disponibles:"
	@echo "  make compile     - Compila el código fuente y coloca los .class en bin/"
	@echo "  make manifest    - Crea el archivo MANIFEST.MF con la clase principal"
	@echo "  make jar         - Crea el archivo JAR utilizando el MANIFEST"
	@echo "  make javadoc     - Genera la documentación Javadoc en el directorio docs/"
	@echo "  make run         - Ejecuta el programa desde el JAR"
	@echo "  make clean       - Elimina los archivos .class, el JAR, el MANIFEST y la documentación"
	@echo "  make clean_all   - Elimina todos los archivos generados, incluyendo el JAR y el MANIFEST"

