package colegio.com.security.service.impl;


import colegio.com.security.model.Menu;
import colegio.com.security.repository.MenuRepositoryJPA;
import colegio.com.security.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {


	private final MenuRepositoryJPA menuRepo;


	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		List<Menu> menus = new ArrayList<>();
		menuRepo.listarMenuPorUsuario(nombre).forEach( x -> {
			Menu m = new Menu();
			m.setIdMenu(Long.parseLong(String.valueOf(x[0])));
			m.setEstado(Boolean.parseBoolean(String.valueOf(x[1])));
			m.setFechaRegistro(LocalDate.parse(String.valueOf(x[2])));
			m.setIcono(String.valueOf(x[3]));
			m.setNombre(String.valueOf(x[4]));
			m.setUrl(String.valueOf(x[5]));

			menus.add(m);
		});
		return menus;
	}

	@Override
	public List<Menu> listarMenu() {
		List<Menu>menu = StreamSupport.stream(
				this.menuRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return menu;
	}

	@Override
	public void insert(Menu menu) {
		LocalDate fechaActual = LocalDate.now();
		menu.setFechaRegistro(fechaActual);
		menuRepo.save(menu);
	}

	@Override
	public void update(Menu menu) {
		LocalDate fechaActual = LocalDate.now();
		menu.setFechaRegistro(fechaActual);
		menuRepo.save(menu);
	}

	@Override
	public void delete(Long menuId) {
		menuRepo.deleteById(menuId);
	}

	@Override
	public Menu findById(Long menuId) {
		return menuRepo.findById(menuId).orElse(null);
	}
}
