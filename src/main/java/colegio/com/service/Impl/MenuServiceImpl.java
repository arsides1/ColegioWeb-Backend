package colegio.com.service.Impl;


import colegio.com.model.Menu;
import colegio.com.repository.MenuRepositoryJPA;
import colegio.com.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {


	private final MenuRepositoryJPA menuRepo;



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
