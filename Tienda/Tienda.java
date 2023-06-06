package Tienda;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Tienda {
    
    Scanner sc=new Scanner(System.in);
    private ArrayList <Pedido> pedidos;
    private ArrayList <Articulo> articulos;
    private ArrayList <Cliente> clientes;

    public Tienda() {
        pedidos = new ArrayList();
        articulos= new ArrayList();
        clientes = new ArrayList();
    }
    
    public static void main(String[] args) {
        Tienda t=new Tienda();
        t.cargadatos();
        t.menu();
        t.archivotexto();     
    }
        
    
     public void cargadatos() {
       clientes.add(new Cliente("11111111A","ANA","658111111"));
       clientes.add(new Cliente("22222222B","LOLA","649222222"));
       clientes.add(new Cliente("33333333C","JUAN","652333333"));
       clientes.add(new Cliente("44444444D","LUIS","635444444"));
       clientes.add(new Cliente("55555555E","EVA","622555555"));
              
       articulos.add(new Articulo("1-001","RATON LOGITECH    ",14,15));
       articulos.add(new Articulo("1-002","TECLADO STANDARD  ",9,18));
       articulos.add(new Articulo("2-001","HDD SEAGATE 1TB   ", 16,80));
       articulos.add(new Articulo("2-002","SSD KINGSTOM 256GB",9,70));
       articulos.add(new Articulo("2-003","SSD KINGSTOM 512GB", 15,120));
       articulos.add(new Articulo("3-001","EPSON ET2800      ",25,200));
       articulos.add(new Articulo("3-002","EPSON XP200       ",15,80));
       articulos.add(new Articulo("4-001","ASUS LED 22       ",25,100));
       articulos.add(new Articulo("4-002","HP LED 28         ",35,180));
       articulos.add(new Articulo("4-003","SAMSUNG ODISSEY G5",22,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("11111111A-001/2023",clientes.get(0),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-001",1),new LineaPedido("2-001",1)))));                                                                                                                                                               //EDU
       pedidos.add(new Pedido("22222222B-001/2023",clientes.get(1),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-001",14),new LineaPedido("4-002",4),new LineaPedido("4-003",4)))));
       pedidos.add(new Pedido("22222222B-002/2023",clientes.get(1),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("3-001",3),new LineaPedido("3-002",3)))));
       pedidos.add(new Pedido("33333333C-001/2023",clientes.get(2),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("3-001",3),new LineaPedido("3-002",3)))));
       pedidos.add(new Pedido("22222222B-003/2023",clientes.get(1),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-001",2),new LineaPedido("2-002",2),new LineaPedido("2-003",2)))));
    }
    
    public void menu(){
      int opcion=0;
      do{
        System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
        System.out.println("\t\t\t\t1 - AÑADIR ARTICULO");
        System.out.println("\t\t\t\t2 - ARCHIVO DE TEXTO");
        System.out.println("\t\t\t\t3 - MOSTRAR 5 ARTICULOS MÁS VENDIDOS");
		System.out.println("\t\t\t\t4 - PEDIDOS ORDENADOS Y TOTALES");
		System.out.println("\t\t\t\t5 - GUARDAR SECCION ARTICULOS EN TXT");
		System.out.println("\t\t\t\t6 - LISTAR PEDIDOS");
		System.out.println("\t\t\t\t7 - LISTAR ARTICULOS");
		System.out.println("\t\t\t\t8 - LISTAR CLIENTES");
		System.out.println("\t\t\t\t9 - SOCKET PEDIDOS");
		System.out.println("\t\t\t\t10 - NUEVO PEDIDO");
		System.out.println("\t\t\t\t11 - PEDIDO CON MAYOR PRECIO");
		System.out.println("\t\t\t\t12 - PEDIDO MÁS GRANDE");
		System.out.println("\t\t\t\t13 - BUSCAR FECHA EN LA QUE SE REALIZÓ UN PEDIDO");
		System.out.println("\t\t\t\t14 - MOSTRAR 5 CLIENTES MÁS COMPRADORES");
		System.out.println("\t\t\t\t15 - MOSTRAR PEDIDO MÁS ANTIGUO");
		System.out.println("\t\t\t\t20 - SALIR");
		opcion = sc.nextInt();
		switch (opcion) {
		case 1: {
			añadirArticulo();
			break;
		}
		case 2: {
			archivotexto();
			break;
		}
		case 3: {
			mostrarArticulosMasVendidos();
			break;
		}
		case 4: {
			pedidosCliente();
			break;
		}
		case 5: {
			guardarSeccionEnTxt();
			break;
		}
		case 6: {
			listaPedidos();
			break;
		}
		case 7: {
			listaArticulos();
			break;
		}
		case 8: {
			listaClientes();
			break;
		}
		case 9: {
			System.out.println("Ingrese el nombre del archivo:");
			String nombreArchivo = sc.next();
			System.out.println("Ingrese la sección:");
			String seccion = sc.next();
			guardarRegistroPedidos(nombreArchivo, seccion);
			break;
		}
		case 10: {
			hacerPedido();
			break;
		}
		case 11: {
			mostrarPedidoMayorPrecio();
			break;
		}
		case 12: {
			mostrarPedidoMasGrande();
			break;
		}
		case 13:{
			obtenerFechaPedido();
			break;
		}
		case 14:{
			mostrarClientesMasCompradores();
			break;
		}
		case 15:{
			mostrarPedidoMasAntiguo();
			break;
		}
		}
	} while (opcion != 20);
}
    
    public void listaPedidos() {
        for (Pedido p:pedidos){
           System.out.println("PEDIDO "+ p.getIdPedido()+ "\tCLIENTE: " + p.getClientePedido().getNombre()
           + "\tFECHA: " + p.getFechaPedido());
        }
    }
    
    public void listaArticulos(){
        System.out.println("\n\n");
        for (Articulo a:articulos){
            System.out.println(a);
        }
    } 
    
    public void listaClientes(){
        System.out.println("\n\n");
        for (Cliente c:clientes){
            System.out.println(c);
        }
    } 
   
    
   //
   // MÉTODOS CORRESPONDIENTES AL EXAMEN AQUÍ
   // 

    public void añadirArticulo() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Añadir un nuevo artículo:");
        System.out.println("Elige la sección a la que va a pertenecer el artículo:");
        System.out.println("1 - PERIFÉRICOS");
        System.out.println("2 - ALMACENAMIENTO");
        System.out.println("3 - IMPRESORAS");
        System.out.println("4 - MONITORES");
        int opcion = sc.nextInt();
        String seccion = "";
        
        switch (opcion) {
            case 1:
                seccion = "1";
                break;
            case 2:
                seccion = "2";
                break;
            case 3:
                seccion = "3";
                break;
            case 4:
                seccion = "4";
                break;
            default:
                System.out.println("Opción inválida. Se asignará la sección por defecto.");
                seccion = "0";
                break;
        }
        
        // Calcular el nuevo ID del artículo
        int contadorArticulos = 0;
        for (Articulo articulo : articulos) {
            if (articulo.getIdArticulo().startsWith(seccion)) {
                contadorArticulos++;
            }
        }
        String nuevoIdArticulo = seccion + "-" + String.format("%03d", contadorArticulos + 1);
        
        System.out.println("Ingrese la descripción del nuevo artículo:");
        sc.nextLine();
        String descripcion = sc.nextLine();
        
        int existencias = 0;
        boolean existenciasValidas = false;
        while (!existenciasValidas) {
            try {
                System.out.println("Ingrese las existencias del nuevo artículo:");
                existencias = sc.nextInt();
                if (existencias <= 0) {
                    throw new IllegalArgumentException("Las existencias deben ser mayores a 0.");
                }
                existenciasValidas = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un valor numérico entero para las existencias.");
                sc.nextLine(); // Limpiar el buffer de entrada
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // Limpiar el buffer de entrada
            }
        }

        double pvp = 0;
        boolean pvpValido = false;
        while (!pvpValido) {
            try {
                System.out.println("Ingrese el precio del nuevo artículo:");
                pvp = sc.nextDouble();
                if (pvp <= 0) {
                    throw new IllegalArgumentException("El precio debe ser mayor a 0.");
                }
                pvpValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un valor numérico para el precio.");
                sc.nextLine(); // Limpiar el buffer de entrada
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine(); // Limpiar el buffer de entrada
            }
        }
        
        // Crear el nuevo artículo
        Articulo nuevoArticulo = new Articulo(nuevoIdArticulo, descripcion, existencias, pvp);
        articulos.add(nuevoArticulo);
        
        System.out.println("El nuevo artículo se ha añadido correctamente.");
    }


	public void archivotexto() {
	    String filePath = "clientesSIN.txt";
	    String filePath2 = "clientesCON.txt";
	    boolean realizapedido;
	    try {
	        FileWriter fileWriter = new FileWriter(filePath);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	        
	        for (Cliente c: clientes) {
	            realizapedido = false;
	            
	            for (Pedido p: pedidos) {
	                if (p.getClientePedido().equals(c)) {
	                    realizapedido = true;
	                    break;
	                }
	            }
	            
	            if (!realizapedido) {
	                bufferedWriter.write(c.toString());
	                bufferedWriter.newLine();
	            }
	        }
	        
	        bufferedWriter.close();
	        System.out.println("Los clientes sin pedidos se han guardado en el archivo.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	    	FileWriter fileWriter = new FileWriter(filePath2);
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	        
	        for(Cliente c: clientes) {
	        	realizapedido=false;
	        	int numPedidos=0;
	        	for(Pedido p: pedidos) {
	        		if(p.getClientePedido().equals(c)) {
	        			realizapedido=true;
	        			numPedidos++;
	        		}
	        	}
	        	if(realizapedido) {
	        		bufferedWriter.write(c.toString() + " - " + numPedidos);
	                bufferedWriter.newLine();
	        	}
	        }
	        bufferedWriter.close();
	        System.out.println("Los clientes con pedidos se han guardado en el archivo.");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void mostrarArticulosMasVendidos() {
	    Map<Articulo, Integer> unidadesVendidas = new HashMap<>();

	    // Calcular las unidades vendidas de cada artículo
	    for (Pedido pedido : pedidos) {
	        for (LineaPedido lineaPedido : pedido.getCestaCompra()) {
	            String idArticulo = lineaPedido.getIdArticulo();
	            int unidades = lineaPedido.getUnidades();

	            // Obtener el artículo correspondiente al idArticulo
	            Articulo articulo = buscarArticuloPorId(idArticulo);

	            // Actualizar las unidades vendidas del artículo
	            if (articulo != null) {
	                int unidadesActuales = unidadesVendidas.getOrDefault(articulo, 0);
	                unidadesVendidas.put(articulo, unidadesActuales + unidades);
	            }
	        }
	    }

	    // Crear una lista auxiliar para ordenar los artículos
	    List<Articulo> artMasVendidos = new ArrayList<>(unidadesVendidas.keySet());

	    // Ordenar la lista según las unidades vendidas en orden descendente
	    Collections.sort(artMasVendidos, new Comparator<Articulo>() {
	        @Override
	        public int compare(Articulo a1, Articulo a2) {
	            int unidadesVendidasA1 = unidadesVendidas.get(a1);
	            int unidadesVendidasA2 = unidadesVendidas.get(a2);
	            return Integer.compare(unidadesVendidasA2, unidadesVendidasA1);
	        }
	    });

	    // Mostrar los primeros 5 artículos más vendidos
	    System.out.println("Los 5 artículos más vendidos:");

	    int numArticulosMostrados = Math.min(5, artMasVendidos.size());

	    for (int i = 0; i < numArticulosMostrados; i++) {
	        Articulo articulo = artMasVendidos.get(i);
	        int unidadesVendidas2 = unidadesVendidas.get(articulo);
	        System.out.println(articulo.getIdArticulo() + " " + articulo.getDescripcion() + " con " + unidadesVendidas2 + " unidades.");
	    }
	}

	private Articulo buscarArticuloPorId(String idArticulo) {
	    for (Articulo articulo : articulos) {
	        if (articulo.getIdArticulo().equals(idArticulo)) {
	            return articulo;
	        }
	    }
	    return null;
	}
	
	public void mostrarClientesMasCompradores() {
	    Map<Cliente, Integer> articulosComprados = new HashMap<>();

	    // Calcular la cantidad de artículos comprados por cada cliente
	    for (Pedido pedido : pedidos) {
	        Cliente cliente = pedido.getClientePedido();
	        int totalArticulos = 0;

	        for (LineaPedido lineaPedido : pedido.getCestaCompra()) {
	            totalArticulos += lineaPedido.getUnidades();
	        }

	        int articulosActuales = articulosComprados.getOrDefault(cliente, 0);
	        articulosComprados.put(cliente, articulosActuales + totalArticulos);
	    }

	    // Crear una lista auxiliar para ordenar los clientes
	    List<Cliente> clientesMasCompradores = new ArrayList<>(articulosComprados.keySet());

	    // Ordenar la lista según la cantidad de artículos comprados en orden descendente
	    Collections.sort(clientesMasCompradores, new Comparator<Cliente>() {
	        @Override
	        public int compare(Cliente c1, Cliente c2) {
	            int articulosCompradosC1 = articulosComprados.get(c1);
	            int articulosCompradosC2 = articulosComprados.get(c2);
	            return Integer.compare(articulosCompradosC2, articulosCompradosC1);
	        }
	    });

	    // Mostrar los primeros 5 clientes que más artículos han comprado
	    System.out.println("Los 5 clientes que más artículos han comprado:");

	    int numClientesMostrados = Math.min(5, clientesMasCompradores.size());

	    for (int i = 0; i < numClientesMostrados; i++) {
	        Cliente cliente = clientesMasCompradores.get(i);
	        int totalArticulosComprados = articulosComprados.get(cliente);
	        System.out.println(cliente.getNombre() + " - " + cliente.getDni() + ": " + totalArticulosComprados + " artículos.");
	    }
	}

	
	public void pedidosCliente() {
	    TreeMap<LocalDate, Pedido> pedidosCliente = new TreeMap<>();

	    // Crear el TreeMap ordenado por fecha de los pedidos
	    for (Pedido p : pedidos) {
	        pedidosCliente.put(p.getFechaPedido(), p);
	    }

	    // Mostrar los pedidos en orden de fecha
	    for (LocalDate fecha : pedidosCliente.keySet()) {
	        Pedido pedido = pedidosCliente.get(fecha);

	        System.out.println("PEDIDO " + pedido.getIdPedido() + " CLIENTE: " + pedido.getClientePedido().getNombre()
	                + " FECHA: " + pedido.getFechaPedido());

	        for (LineaPedido linea : pedido.getCestaCompra()) {
	            Articulo articulo = buscarArticuloPorId(linea.getIdArticulo());
	            System.out.println(articulo.getDescripcion() + "\t- " + linea.getUnidades());
	        }

	        double total = calcularTotalPedido(pedido);
	        System.out.println("EL TOTAL DEL PEDIDO ES: " + total + "\n");
	    }
	}
	
	private double calcularTotalPedido(Pedido pedido) {
	    double total = 0;
	    for (LineaPedido linea : pedido.getCestaCompra()) {
	        Articulo articulo = buscarArticuloPorId(linea.getIdArticulo());
	        total += linea.getUnidades() * articulo.getPvp();
	    }
	    return total;
	}
	
	public void guardarSeccionEnTxt() {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Guardar artículos de una sección en un archivo de texto");
	    System.out.println("Elige la sección de la que deseas guardar los artículos:");
	    System.out.println("1 - PERIFÉRICOS");
	    System.out.println("2 - ALMACENAMIENTO");
	    System.out.println("3 - IMPRESORAS");
	    System.out.println("4 - MONITORES");
	    int opcion = sc.nextInt();
	    String seccion = "";

	    switch (opcion) {
	        case 1:
	            seccion = "1";
	            break;
	        case 2:
	            seccion = "2";
	            break;
	        case 3:
	            seccion = "3";
	            break;
	        case 4:
	            seccion = "4";
	            break;
	        default:
	            System.out.println("Opción inválida. No se guardarán artículos en el archivo de texto.");
	            return;
	    }

	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(seccion + ".txt"))) {
	        for (Articulo articulo : articulos) {
	            if (articulo.getIdArticulo().startsWith(seccion)) {
	                writer.write(articulo.toString());
	                writer.newLine();
	            }
	        }

	        System.out.println("Los artículos de la sección " + seccion + " se han guardado en el archivo de texto.");
	    } catch (IOException e) {
	        System.out.println("Error al guardar los artículos en el archivo de texto.");
	        e.printStackTrace();
	    }
	}
	//Método que no funciona del todo...
	public void guardarRegistroPedidos(String nombreArchivo, String seccion) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
	        for (Pedido pedido : pedidos) {
	            boolean seccionEncontrada = false;
	            for (LineaPedido lineaPedido : pedido.getCestaCompra()) {
	                String idArticulo = lineaPedido.getIdArticulo();
	                Articulo articulo = buscarArticuloPorId(idArticulo);
	                if (articulo != null && obtenerSeccionArticulo(articulo).equals(seccion)) {
	                    seccionEncontrada = true;
	                    break;
	                }
	            }
	            if (seccionEncontrada) {
	                writer.write("ID Pedido: " + pedido.getIdPedido());
	                writer.newLine();
	                writer.write("Cliente: " + pedido.getClientePedido().getNombre());
	                writer.newLine();
	                writer.newLine();
	            }
	        }
	        System.out.println("El registro de pedidos de la sección " + seccion + " se ha guardado correctamente en el archivo " + nombreArchivo);
	    } catch (IOException e) {
	        System.out.println("Error al guardar el registro de pedidos en el archivo " + nombreArchivo);
	        e.printStackTrace();
	    }
	}

	private String obtenerSeccionArticulo(Articulo articulo) {
	    String idArticulo = articulo.getIdArticulo();
	    if (idArticulo.startsWith("1")) {
	        return "PERIFÉRICOS";
	    } else if (idArticulo.startsWith("2")) {
	        return "ALMACENAMIENTO";
	    } else if (idArticulo.startsWith("3")) {
	        return "IMPRESORAS";
	    } else if (idArticulo.startsWith("4")) {
	        return "MONITORES";
	    } else {
	        return "Desconocida";
	    }
	}
	
	public void altaPedido(){
        ArrayList<LineaPedido> pedidoAux = new ArrayList();
        LocalDate hoy;
                          
        System.out.println("INTRODUCE EL DNI CLIENTE PARA EL PEDIDO: ");
        String dni = sc.next();
       
        System.out.println("SE VAN A INTRODUCIR LOS ARTÍCULOS 1 A 1: ");
        System.out.println("INTRODUCE CODIGO ARTICULO (99 PARA TERMINAR): ");
        String id=sc.next();
        while (!id.equals("99")){
          System.out.println("CUANTAS UNIDADES QUIERES ?:");
          pedidoAux.add(new LineaPedido (id,sc.nextInt()));
          articulos.get(buscaId(id)).setExistencias(articulos.get(buscaId(id)).getExistencias()-1);
          System.out.println("INTRODUCE CODIGO ARTICULO (99 PARA TERMINAR): ");
          id=sc.next();
        }
        hoy=LocalDate.now();
        
	    //LLAMADA AL MÉTODO generaIdPedido() - ALTA DEL NUEVO PEDIDO EN EL ARRAYLIST
        pedidos.add(new Pedido(generaIdPedido(dni),clientes.get(buscarDni(dni)),hoy, pedidoAux));
    }
    
    
    private String generaIdPedido(String idCliente){
        int contador =0;
        String nuevoId;
        for (Pedido p: pedidos){
            if (p.getClientePedido().getDni().equalsIgnoreCase(idCliente)){
                contador++;
            }
        }
        contador++;
        nuevoId= idCliente + "-" + String.format("%03d", contador) + "/2023";
        return nuevoId;
    }
	
	
	
	public void listaArticulosOrdenados() {
		String[] secciones={"PERIFERICOS","ALMACENAMIENTO","IMPRESORAS","MONITORES"};
        sc.nextLine();
        System.out.println("PARA ORDENAR POR PRECIO < a >(-) > a <(+)");
        String s= sc.nextLine();
        
        // PREPARO EL ARRAYLIST AUXILIAR DE ORDENACIONES articulosL SEGÚN EL CRITERIO ESPECIFICADO
        if (s.charAt(0)=='-'){
            Collections.sort(articulos,new ComparaArticuloPorPrecio());
        }else if (s.charAt(0)=='+'){
               Collections.sort(articulos,new ComparaArticuloPorPrecio());
               Collections.reverse(articulos);
        }
        
        for (int i=0;i<=3;i++){
            System.out.println(secciones[i]);            
            Iterator <Articulo> it = articulos.iterator();
            while (it.hasNext()){
                Articulo a=it.next();
                if (Character.getNumericValue(a.getIdArticulo().charAt(0))==i+1){
                    System.out.println(a);
                }
            }   
        }
	}
	
	public void clienteconMasPedidos() {
	    Cliente clienteMasPedidos = null;
	    int maxPedidos = 0;

	    for (Pedido pedido : pedidos) {
	        Cliente cliente = pedido.getClientePedido();
	        int contador = 0;

	        for (Pedido otroPedido : pedidos) {
	            if (otroPedido.getClientePedido().equals(cliente)) {
	                contador++;
	            }
	        }

	        if (contador > maxPedidos) {
	            maxPedidos = contador;
	            clienteMasPedidos = cliente;
	        }
	    }

	    if (clienteMasPedidos != null) {
	        System.out.println("El cliente con más pedidos es: " + clienteMasPedidos.getNombre()
	            + " con " + maxPedidos + " pedidos.");
	    } else {
	        System.out.println("No hay clientes con pedidos.");
	    }
	}
	
	public void ArticuloconMasPrecio() {
	    Articulo articuloMasPrecio = null;
	    double maxPrecio = 0;

	    for (Articulo articulo : articulos) {
	        double precio = articulo.getPvp();
	        if (precio > maxPrecio) {
	            maxPrecio = precio;
	            articuloMasPrecio = articulo;
	        }
	    }

	    if (articuloMasPrecio != null) {
	        System.out.println("El artículo con mayor precio es: " + articuloMasPrecio.getDescripcion());
	        System.out.println("Precio: " + articuloMasPrecio.getPvp());
	    } else {
	        System.out.println("No hay artículos disponibles.");
	    }
	}
	
	public void buscarCliente() {
        Scanner sc = new Scanner(System.in);
        
        // Buscar cliente por DNI
        System.out.print("Introduce el DNI del cliente: ");
        String dniCliente = sc.nextLine();
        
        int posicionCliente = buscarDni(dniCliente);
        
        if (posicionCliente != -1) {
            Cliente clienteEncontrado = clientes.get(posicionCliente);
            System.out.println("Cliente encontrado:\n" + clienteEncontrado);
        } else {
            try {
                throw new NoEncontrado("No se encontró ningún cliente con el DNI: " + dniCliente);
            } catch (NoEncontrado e) {
                System.out.println(e.getMessage());
			}
		}
	}
	
      public void buscarArticulo() {
            Scanner sc = new Scanner(System.in);  
        // Buscar artículo por ID
        System.out.print("Introduce el ID del artículo: ");
        String idArticulo = sc.nextLine();
        
        int posicionArticulo = buscaId(idArticulo);
        
        if (posicionArticulo != -1) {
            Articulo articuloEncontrado = articulos.get(posicionArticulo);
            System.out.println("Artículo encontrado:\n" + articuloEncontrado);
        } else {
            try {
                throw new NoEncontrado("No se encontró ningún artículo con el ID: " + idArticulo);
            } catch (NoEncontrado e) {
                System.out.println(e.getMessage());
            }
        }
    }


      public void aplicarCuponDescuento() {
    	    for (Cliente cliente : clientes) {
    	        double totalGastado = 0;
    	        
    	        for (Pedido pedido : pedidos) {
    	            if (pedido.getClientePedido().equals(cliente)) {
    	                for (LineaPedido linea : pedido.getCestaCompra()) {
    	                    Articulo articulo = buscarArticuloPorId(linea.getIdArticulo());
    	                    totalGastado += articulo.getPvp() * linea.getUnidades();
    	                }
    	            }
    	        }
    	        
    	        if (totalGastado > 500) {
    	            double descuento = totalGastado * 0.05;
    	            System.out.println(cliente.getNombre() + " TIENE PEDIDOS POR VALOR DE: " + 
    	            totalGastado + " Y HA OBTENIDO UN CUPÓN DESCUENTO POR VALOR DE: " + descuento);
    	            double totalConDescuento = totalGastado - descuento;
    	            System.out.println("Total a pagar: " + totalConDescuento);
    	            System.out.println("-------------------------------------");
    	        }
    	    }
    	}
      
      public void hacerPedido() {
          Scanner sc = new Scanner(System.in);

          System.out.println("Realizar un pedido");
          System.out.println("Ingrese el DNI del cliente:");
          String dniCliente = sc.nextLine();

          // Buscar al cliente por su DNI en la lista de clientes
          Cliente cliente = buscarClientePorDni(dniCliente);
          if (cliente == null) {
              System.out.println("Cliente no encontrado. No se puede realizar el pedido.");
              return;
          }

          LocalDate fechaPedido = LocalDate.now(); // Obtener la fecha del sistema

          ArrayList<LineaPedido> cestaCompra = new ArrayList<>();
          boolean agregarArticulo = true;
          while (agregarArticulo) {
              System.out.println("Ingrese el ID del artículo:");
              String idArticulo = sc.nextLine();

              // Buscar el artículo por su ID en la lista de artículos
              Articulo articulo = buscarArticuloPorId(idArticulo);
              if (articulo == null) {
                  System.out.println("Artículo no encontrado.");
                  continue;
              }

              System.out.println("Ingrese la cantidad de unidades:");
              int unidades = sc.nextInt();
              sc.nextLine(); // Limpiar el buffer del scanner

              try {
                  validarStock(articulo, unidades);
                  cestaCompra.add(new LineaPedido(idArticulo, unidades));
                  System.out.println("Artículo agregado al pedido.");
              } catch (StockInsuficiente e) {
                  System.out.println("No hay suficientes unidades de este artículo en stock.");
              }

              System.out.println("¿Desea agregar otro artículo al pedido? (s/n)");
              String respuesta = sc.nextLine();
              agregarArticulo = respuesta.equalsIgnoreCase("s");
          }

          if (cestaCompra.isEmpty()) {
              System.out.println("El pedido está vacío. No se puede realizar el pedido.");
              return;
          }

          String idPedido = generarIdPedido(cliente);
          Pedido pedido = new Pedido(idPedido, cliente, fechaPedido, cestaCompra);
          pedidos.add(pedido);

          System.out.println("Pedido realizado correctamente.");
      }
      
      
      //Muestro el pedido que más caro ha sido o el que mayor precio ha tenido
      
      public void mostrarPedidoMayorPrecio() {
    	    Pedido pedidoMayorPrecio = null;
    	    double mayorPrecio = 0.0;

    	    for (Pedido pedido : pedidos) {
    	        double precioPedido = calcularPrecioPedido(pedido);

    	        if (precioPedido > mayorPrecio) {
    	            mayorPrecio = precioPedido;
    	            pedidoMayorPrecio = pedido;
    	        }
    	    }

    	    if (pedidoMayorPrecio != null) {
    	        System.out.println("Pedido con mayor precio:");
    	        System.out.println("ID Pedido: " + pedidoMayorPrecio.getIdPedido());
    	        System.out.println("Cliente: " + pedidoMayorPrecio.getClientePedido().getNombre());
    	        System.out.println("Fecha: " + pedidoMayorPrecio.getFechaPedido());
    	        System.out.println("Precio Total: " + mayorPrecio);
    	    } else {
    	        System.out.println("No se encontró ningún pedido.");
    	    }
    	}

    	private double calcularPrecioPedido(Pedido pedido) {
    	    double precioTotal = 0.0;

    	    for (LineaPedido lineaPedido : pedido.getCestaCompra()) {
    	        String idArticulo = lineaPedido.getIdArticulo();
    	        int cantidad = lineaPedido.getUnidades();

    	        Articulo articulo = buscarArticuloPorId(idArticulo);
    	        double precioArticulo = articulo.getPvp();

    	        double subtotal = precioArticulo * cantidad;
    	        precioTotal += subtotal;
    	    }

    	    return precioTotal;
    	}
    	
    	
    	public void mostrarPedidoMasGrande() {
    	    Pedido pedidoMasGrande = null;
    	    int unidadesTotales = 0;
    	    HashMap<String, Integer> unidadesPorArticulo = new HashMap<>();

    	    for (Pedido pedido : pedidos) {
    	        int unidadesPedido = calcularUnidadesPedido(pedido);

    	        if (pedidoMasGrande == null || unidadesPedido > unidadesTotales) {
    	            pedidoMasGrande = pedido;
    	            unidadesTotales = unidadesPedido;
    	        }

    	        actualizarUnidadesPorArticulo(pedido, unidadesPorArticulo);
    	    }

    	    if (pedidoMasGrande != null) {
    	        System.out.println("El cliente que ha hecho el pedido más grande ha sido: " + 
    	        pedidoMasGrande.getClientePedido().getNombre() + " y ha pedido un total de " + unidadesTotales + " unidades.");
    	        System.out.println("Id de pedido: " + pedidoMasGrande.getIdPedido());
    	        System.out.println("Unidades por Artículo:");

    	        for (Map.Entry<String, Integer> entry : unidadesPorArticulo.entrySet()) {
    	            String idArticulo = entry.getKey();
    	            int unidades = entry.getValue();

    	            Articulo articulo = buscarArticuloPorId(idArticulo);
    	            System.out.println("Artículo: " + articulo.getDescripcion() + ", Unidades: " + unidades);
    	        }
    	    } else {
    	        System.out.println("No se encontró ningún pedido.");
    	    }
    	}

    	private int calcularUnidadesPedido(Pedido pedido) {
    	    int unidadesTotales = 0;

    	    for (LineaPedido lineaPedido : pedido.getCestaCompra()) {
    	        int unidades = lineaPedido.getUnidades();
    	        unidadesTotales += unidades;
    	    }

    	    return unidadesTotales;
    	}

    	private void actualizarUnidadesPorArticulo(Pedido pedido, HashMap<String, Integer> unidadesPorArticulo) {
    	    for (LineaPedido lineaPedido : pedido.getCestaCompra()) {
    	        String idArticulo = lineaPedido.getIdArticulo();
    	        int unidades = lineaPedido.getUnidades();

    	        if (unidadesPorArticulo.containsKey(idArticulo)) {
    	            unidades += unidadesPorArticulo.get(idArticulo);
    	        }

    	        unidadesPorArticulo.put(idArticulo, unidades);
    	    }
    	}

    	public void obtenerFechaPedido() {
    	    System.out.println("Ingrese el ID del pedido:");
    	    String idPedido = sc.nextLine();

    	    Pedido pedido = buscarPedidoPorId(idPedido);
    	    if (pedido == null) {
    	        System.out.println("No se encontró el pedido con el ID especificado.");
    	    } else {
    	        LocalDate fechaPedido = pedido.getFechaPedido();
    	        System.out.println("La fecha del pedido " + idPedido + " es: " + fechaPedido);
    	    }
    	}

    	private Pedido buscarPedidoPorId(String idPedido) {
    	    for (Pedido pedido : pedidos) {
    	        if (pedido.getIdPedido().equals(idPedido)) {
    	            return pedido;
    	        }
    	    }
    	    return null;
    	}
    	
    	//Metodo para saber cual es el pedido más antiguo
    	public void mostrarPedidoMasAntiguo() {
    	    if (pedidos.isEmpty()) {
    	        System.out.println("No hay pedidos en la tienda.");
    	        return;
    	    }

    	    Pedido pedidoMasAntiguo = pedidos.get(0);

    	    for (Pedido pedido : pedidos) {
    	        if (pedido.getFechaPedido().isBefore(pedidoMasAntiguo.getFechaPedido())) {
    	            pedidoMasAntiguo = pedido;
    	        }
    	    }

    	    System.out.println("El pedido más antiguo es:" + pedidoMasAntiguo.getIdPedido()
    	    + " el cliente que lo hizo fue: " + pedidoMasAntiguo.getClientePedido().getNombre());
    	    System.out.println("Fecha: " + pedidoMasAntiguo.getFechaPedido());
    	    
    	    for (LineaPedido lineaPedido : pedidoMasAntiguo.getCestaCompra()) {
    	        Articulo articulo = buscarArticuloPorId(lineaPedido.getIdArticulo());
    	        if (articulo != null) {
    	            System.out.println("ID Artículo: " + articulo.getIdArticulo());
    	            System.out.println("Descripción: " + articulo.getDescripcion());
    	            System.out.println("Unidades: " + lineaPedido.getUnidades());
    	            System.out.println("-----------------------");
    	        }
    	    }
    	}



      //MÉTODOS AUXILIARES
		private void validarStock(Articulo articulo, int unidades) throws StockInsuficiente {
			if (articulo.getExistencias() < unidades) {
				throw new StockInsuficiente("No hay suficientes unidades de este artículo en stock.");
			}
		}

		public String generarIdPedido(Cliente cliente) {
			int numPedidosCliente = 0;
			for (Pedido pedido : pedidos) {
				if (pedido.getClientePedido().equals(cliente)) {
					numPedidosCliente++;
				}
			}
			String idPedido = String.format("%s-%03d/%d", cliente.getDni(), numPedidosCliente + 1,
			LocalDate.now().getYear());
			return idPedido;
		}

		public Cliente buscarClientePorDni(String dni) {
			for (Cliente cliente : clientes) {
				if (cliente.getDni().equals(dni)) {
					return cliente;
				}
			}
			return null;
		}
		
		/*private Articulo buscarId(String idArticulo) {
		    for (Articulo articulo : articulos) {
		        if (articulo.getIdArticulo().equals(idArticulo)) {
		            return articulo;
		        }
		    }
		    return null;
		}*/

		public int buscarDni(String dni) {
	        int pos=-1;
	        int i=0;
	        for (Cliente c : clientes) {
	             if (c.getDni().equals(dni)){
	                 pos=i;
	                 break;
	             }
	             i++;
	        }
	        return pos;
	    }
	    
	    public int buscaId(String id) {
	        int pos=-1;
	        int i=0;
	        for (Articulo a : articulos) {
	             if (a.getIdArticulo().equals(id)){
	                 pos=i; 
	                 break;
	             }
	             i++;
	        }
	        return pos;
	    }
}  
    