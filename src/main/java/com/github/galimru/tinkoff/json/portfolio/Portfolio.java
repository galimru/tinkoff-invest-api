package com.github.galimru.tinkoff.json.portfolio;

import java.util.List;

public class Portfolio {

    private List<PortfolioPosition> positions;

    public List<PortfolioPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<PortfolioPosition> positions) {
        this.positions = positions;
    }
}
