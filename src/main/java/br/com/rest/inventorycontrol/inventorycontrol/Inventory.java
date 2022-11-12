package br.com.rest.inventorycontrol.inventorycontrol;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {
    
	private @Id @GeneratedValue Long codProd;
	private String nameProd;
	private BigInteger codBar;
    private BigDecimal quantity;
    private BigDecimal price;

	Inventory() {}

	Inventory(String nameProd, BigInteger codBar, BigDecimal quantity, BigDecimal price) {
		this.nameProd = nameProd;
        this.codBar = codBar;
        this.quantity = quantity;
        this.price = price;
	}

	public Long getCodProd() {
        return codProd;
    }

    public String getNameProd() {
        return nameProd;
    }

    public BigInteger getCodBar() {
        return codBar;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public void setCodBar(BigInteger codBar) {
        this.codBar = codBar;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCodProd(Long codProd) {
        this.codProd = codProd;
    }

    @Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Inventory))
			return false;
            Inventory inventory = (Inventory) o;
		return Objects.equals(this.codProd, inventory.codProd) && Objects.equals(this.nameProd, inventory.nameProd)
				&& Objects.equals(this.codBar, inventory.codBar) && Objects.equals(this.quantity, inventory.quantity)
                && Objects.equals(this.price, inventory.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.codProd, this.nameProd, this.codBar, this.quantity, this.price);
	}

	@Override
	public String toString() {
		return "Inventory{" + "codProd=" + this.codProd + ", nameProd='" + this.nameProd + ", codBar='" + this.codBar + 
        ", quantity='" + this.quantity + ", price='" + this.price + '\'' + '}';
	}
    
}
