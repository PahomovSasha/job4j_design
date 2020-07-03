package ru.job4j.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {
    @Test
    public void whenAddAndGetNewRoleForRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role roleOne = new Role("123456", "Паша");
        roleStore.add(roleOne);
        Role result = roleStore.findById(roleOne.getId());
        assertThat(result.getRole(), is(roleOne.getRole()));
    }

    @Test
    public void addAndGetRoleForRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role roleOne = new Role("123456", "Паша");
        Role roleTwo = new Role("987654", "Коля");
        roleStore.add(roleOne);
        roleStore.add(roleTwo);
        ArrayList<Role> result = (ArrayList<Role>) roleStore.findAll();
        assertThat(result, is(new ArrayList<>(Arrays.asList(roleOne, roleTwo))));
    }

    @Test
    public void findItemByIdForRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role roleOne = new Role("123456", "Паша");
        roleStore.add(roleOne);
        Role result = roleStore.findById(roleOne.getId());
        assertThat(result, is(roleOne));
    }

    @Test
    public void findItemByIncorrectIdForRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role roleOne = new Role("123456", "Паша");
        roleStore.add(roleOne);
        Role result = roleStore.findById("TEST");
        assertNull(result);
    }

    @Test
    public void whenDeleteForRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role roleOne = new Role("123456", "Паша");
        roleStore.add(roleOne);
        roleStore.delete(roleOne.getId());
        assertThat(roleStore.findById(roleOne.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceForRoleStore() {
        RoleStore roleStore = new RoleStore();
        Role roleOne = new Role("123456", "Паша");
        Role roleTwo = new Role("987654", "Коля");
        roleStore.add(roleOne);
        roleStore.replace(roleOne.getId(), roleTwo);
        assertThat(roleStore.findById(roleOne.getId()), is(nullValue()));
        assertThat(roleStore.findById(roleTwo.getId()), is(roleTwo));
    }
}
