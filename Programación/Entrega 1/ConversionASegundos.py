
def CalcularSegundos(LaHora, LosMinutos, LosSegundos):
    Total = (LaHora*60*60) + (LosMinutos*60) + LosSegundos
    return Total

# Aqui comienza el programa principal
HH = int(input("Entre las horas del día:"))
MM = int(input("Entre los minutos de la hora:"))
SS = int(input("Entre los segundos del minuto:"))

TotalSegundos =CalcularSegundos(HH,MM,SS)
print("En el dia, a las %2d:%02d:%02d van %d segundos"%(HH,MM,SS,TotalSegundos))
# En las cadenas %d significa "aquí van unos dígitos o números decimales"
# En las cadenas %2d significa "aquí van dos dígitos siempre"

# http://python.org/
# Windows : ActivePython https://www.activestate.com/products/python/downloads/
# MS Visual Studio Code, descargar, instalar, crear un archivo, así sea en blanco y grabar
#                        con extensión .py
#                        Inmediatamente aparece un asistente que dice "Monto el paquete Python?"
